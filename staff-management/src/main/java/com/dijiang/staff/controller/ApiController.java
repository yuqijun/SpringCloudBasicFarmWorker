package com.dijiang.staff.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dijiang.common.controller.BaseController;
import com.dijiang.staff.model.AuthorSimpleMessageListenerContainer;
import com.dijiang.common.entity.RabbitQueueInfo;
import com.dijiang.common.entity.ResponseResult;
import com.dijiang.common.entity.vo.RabbitUpdateVo;
import com.dijiang.staff.config.RabbitMQConfig2;
import com.dijiang.staff.service.impl.RabbitQueueInfoServiceImpl;
import com.dijiang.staff.service.impl.SentinelTestServiceImpl;
import com.rabbitmq.client.Channel;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/8 17:21
 */

@Slf4j
@RequestMapping("/api")
@RestController
public class ApiController extends BaseController {


    @Autowired
    @Qualifier("SentinelTestServiceImpl")
    private SentinelTestServiceImpl sentinelTestService;

    @Value("${timeout}")
    String timeout ;

    @Value("${publicKey}")
    String publicKey ;

    @Autowired
    private RabbitQueueInfoServiceImpl rabbitQueueInfoService;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @GetMapping("/apollo-test")
    public ResponseResult apolloTest(){
        Map  map = new HashMap();
        map.put("timeout",timeout);
        map.put("publicKey",publicKey);
        return SuccessResult(map);
    }

    @GetMapping("/sentinel-current-limit")
    public ResponseResult sentinelCurrentLimit(){
        return  SuccessResult(sentinelTestService.getUser());
    }


    public ResponseResult handleBlock( BlockedException ex){
        log.info("异常信息-----"+ex);
        return FailResult("服务限流.....");
    }

    public ResponseResult fallBack(Integer id, BlockException e){
        return  FailResult("服务降级...");
    }

    @GetMapping("/hello")
    public ResponseResult hello(){
        log.info("通过fetch 进入到了 控制器中");
        return SuccessResult();
    }

    @PostMapping("/queue_info_id")
    public ResponseResult selectByApplicationId(@RequestBody RabbitQueueInfo info){
        return SuccessResult(rabbitQueueInfoService.selectListByApplicationId(info.getApplicationId()));
    }


    //查询当前所有  Rabbit   队列配置信息
    @GetMapping("/queue_selectPage")
    public ResponseResult selectPage(){
        List<RabbitQueueInfo> list = new ArrayList<>();

        for(Map.Entry<String,List<SimpleMessageListenerContainer>> entry : RabbitMQConfig2.containerMap.entrySet()) {
            String applicationId = entry.getKey();
            for(SimpleMessageListenerContainer container : entry.getValue()){
                RabbitQueueInfo queueInfo = new RabbitQueueInfo();
                log.info("设置队列名  {}",container.getQueueNames()[0]);
                queueInfo.setName(container.getQueueNames()[0]);
                queueInfo.setConcurrentConsumers(container.getActiveConsumerCount());
                queueInfo.setApplicationId(applicationId);
                list.add(queueInfo);
            }
        }
        return SuccessResult(list);
    }

    @GetMapping("/rabbit_queue_selectByQueueName")
    public ResponseResult selectByQueueName(@RequestBody RabbitUpdateVo vo){

        SimpleMessageListenerContainer container = queryByQueueName(vo.getQueueName());
        log.info("根据队列名找到的容器   {}", JSON.toJSONString(container));
        return  SuccessResult(container);
    }

    //修改某个 队列配置信息
    @PostMapping("/rabbit_queue_update_by_queueName")
    public ResponseResult updateByQueueName(@RequestBody RabbitUpdateVo vo){
        SimpleMessageListenerContainer container = queryByQueueName(vo.getQueueName());
        updateQueue(container,vo);
        return SuccessResult();
    }

    private SimpleMessageListenerContainer queryByQueueName(String queueName){
        if(StringUtil.isNotBlank(queueName)) {
            for (Map.Entry<String, List<SimpleMessageListenerContainer>> entry : RabbitMQConfig2.containerMap.entrySet()) {
                for (SimpleMessageListenerContainer container : entry.getValue()) {
                    String[] queueNames = container.getQueueNames();
                    for (int i = 0; i < queueNames.length; i++) {
                        if (queueName.equals(queueNames[i])) {
                            return container;
                        }
                    }
                }
            }
        }
        return null;
    }

    private void updateQueue(SimpleMessageListenerContainer container , RabbitUpdateVo vo){

        if(null != vo){
            if(null != vo.getConcurrentConsumers() && !"".equals(vo.getConcurrentConsumers())){
                log.info("队列 {} 当前状态 {}    当前活跃消费这数量为 {}    将修改为 {}",container.getQueueNames()[0],container.isActive(),container.getActiveConsumerCount(),vo.getConcurrentConsumers());
                Iterator<Map.Entry<String,List<SimpleMessageListenerContainer>>> it = RabbitMQConfig2.containerMap.entrySet().iterator();
                while(it.hasNext()){
                        List<SimpleMessageListenerContainer> simpleMessageListenerContainerList =it.next().getValue();
                        Iterator<SimpleMessageListenerContainer> sit = simpleMessageListenerContainerList.iterator();
                        while(sit.hasNext()){
                        SimpleMessageListenerContainer container1 = sit.next();
                        //如果找到容器
                        if(container == container1 ){

                            //停止容器 ，删除容器
                            container1.stop();
                            simpleMessageListenerContainerList.remove(container1);

                            log.info("移除容器后的 容器列表  {}",JSON.toJSONString(RabbitMQConfig2.containerMap));


                            //重新创建容器
                            LambdaQueryWrapper<RabbitQueueInfo> lambda = new LambdaQueryWrapper<>();
                            lambda.eq(RabbitQueueInfo::getName,vo.getQueueName());
                            RabbitQueueInfo queueInfo =  rabbitQueueInfoService.getOne(lambda);
                            SimpleMessageListenerContainer  container2  = new SimpleMessageListenerContainer(connectionFactory);
                            Queue queue = new Queue(queueInfo.getName()+"-testUpdate", queueInfo.isDurable(), queueInfo.isExclusive(), queueInfo.isAutoDelete(),null);
                            rabbitAdmin.declareQueue(queue);
                            container2.addQueues(queue);

                            container2.setConcurrentConsumers(vo.getConcurrentConsumers());
                            container2.setMaxConcurrentConsumers(queueInfo.getMaxConcurrentConsumers());
                            container2.setDefaultRequeueRejected(false);
                            if (AcknowledgeMode.AUTO.equals(queueInfo.getAcknowledgeMode())) {
                                container2.setAcknowledgeMode(AcknowledgeMode.AUTO);
                            }
                            if (AcknowledgeMode.NONE.equals(queueInfo.getAcknowledgeMode())) {
                                container2.setAcknowledgeMode(AcknowledgeMode.NONE);
                            }
                            if (AcknowledgeMode.MANUAL.equals(queueInfo.getAcknowledgeMode())) {
                                container2.setAcknowledgeMode(AcknowledgeMode.MANUAL);
                            }

                            container2.setExposeListenerChannel(true);

                            //设置消费端标签策略
                            container2.setConsumerTagStrategy(new ConsumerTagStrategy() {
                                @Override
                                public String createConsumerTag(String queue) {
                                    return queue + "_" + UUID.randomUUID().toString();
                                }
                            });
                            //设置消息监听
                            container2.setMessageListener(new ChannelAwareMessageListener() {
                                @Override
                                public void onMessage(Message message, Channel channel) throws Exception {
                                    String msg = new String(message.getBody(), "utf-8");
                                    System.out.println("-----------消费者：" + msg);
                                }
                            });
                            //开启容器
                            container2.start();
                            //添加容器
                            simpleMessageListenerContainerList.add(container2);
                            log.info("添加容器后的容器列表 {}",JSON.toJSONString(RabbitMQConfig2.containerMap));
                        }
                    }
                }
            }
        }
    }




}

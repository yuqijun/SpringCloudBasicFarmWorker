//package com.dijiang.staff.config;
//
//import com.alibaba.fastjson.JSON;
//import com.dijiang.common.entity.RabbitMQQueueInfo;
//import com.dijiang.common.entity.RabbitMQSetting;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.amqp.support.ConsumerTagStrategy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;
///* version：  0.0.2
//*  description： 创建 一个  SimpleMessageListenerContainer 容器集合，每个容器监听一个队列。该队列代表一个系统，
//* */
//
//
//
//@Slf4j
//@Configuration
//public class RabbitMQConfig2 {
//
//    public static ConcurrentHashMap<String,SimpleMessageListenerContainer> concurrentContainer = new ConcurrentHashMap<>();
//
//    @Autowired
//    private RabbitAdmin rabbitAdmin;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setAddresses("101.132.143.228:5672");
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        return connectionFactory;
//    }
//
//    @Bean
//    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//        System.err.println("RabbitAdmin启动了。。。");
//        //设置启动spring容器时自动加载这个类(这个参数现在默认已经是true，可以不用设置)
//        rabbitAdmin.setAutoStartup(true);
//        return rabbitAdmin;
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        return rabbitTemplate;
//    }
//
//
//    /*
//     *     简单消息监听容器
//     *     1.  优化：从数据库里面查出MQ的配置信息，然后放到监听容器里面
//     */
//    @Bean
//    public ConcurrentHashMap<String,SimpleMessageListenerContainer> messageContainer(ConnectionFactory connectionFactory) {
//
////        模拟数据
//
//        List<RabbitMQSetting> list = new ArrayList<>();
//
//        RabbitMQSetting mqSetting1 = new RabbitMQSetting();
//        mqSetting1.setApplicationId("100100");
//        mqSetting1.setApplicationName("多盈");
//        mqSetting1.setModularId("200100");
//        mqSetting1.setModularName("财务");
//
//        RabbitMQQueueInfo queueInfo1 = new RabbitMQQueueInfo();
//        queueInfo1.setAutoDelete("false");
//        queueInfo1.setDurable("true");
//        queueInfo1.setExclusive("false");
//        queueInfo1.setName("xiaomingQueue");
//        queueInfo1.setConcurrentConsumers(1);
//        queueInfo1.setMaxConcurrentConsumers(5);
//        queueInfo1.setAcknowledgeMode("AUTO");
//        queueInfo1.setDefaultRequeueRejected(false);
//        queueInfo1.setExposeListenerChannel(true);
//        List<RabbitMQQueueInfo> queueInfoList1 = new ArrayList<>();
//        queueInfoList1.add(queueInfo1);
//        mqSetting1.setQueueInfo(queueInfoList1);
//
//
//
//        RabbitMQSetting mqSetting2 = new RabbitMQSetting();
//        mqSetting2.setApplicationId("100200");
//        mqSetting2.setApplicationName("鑫民");
//        mqSetting2.setModularId("200200");
//        mqSetting2.setModularName("咨询");
//
//        RabbitMQQueueInfo queueInfo2 = new RabbitMQQueueInfo();
//        queueInfo2.setAutoDelete("false");
//        queueInfo2.setDurable("true");
//        queueInfo2.setExclusive("false");
//        queueInfo2.setName("zhouyuchaoQueue");
//        queueInfo2.setConcurrentConsumers(1);
//        queueInfo2.setMaxConcurrentConsumers(5);
//        queueInfo2.setAcknowledgeMode("AUTO");
//        queueInfo2.setDefaultRequeueRejected(false);
//        queueInfo2.setExposeListenerChannel(true);
//        List<RabbitMQQueueInfo> queueInfoList2 = new ArrayList<>();
//        queueInfoList2.add(queueInfo2);
//        mqSetting2.setQueueInfo(queueInfoList2);
//
//
//        RabbitMQSetting mqSetting3 = new RabbitMQSetting();
//        mqSetting3.setApplicationId("100300");
//        mqSetting3.setApplicationName("融利泉");
//        mqSetting3.setModularId("200300");
//        mqSetting3.setModularName("设置");
//
//        RabbitMQQueueInfo queueInfo3 = new RabbitMQQueueInfo();
//        queueInfo3.setAutoDelete("false");
//        queueInfo3.setDurable("true");
//        queueInfo3.setExclusive("false");
//        queueInfo3.setName("xushaofanQueue");
//        queueInfo3.setConcurrentConsumers(1);
//        queueInfo3.setMaxConcurrentConsumers(5);
//        queueInfo3.setAcknowledgeMode("AUTO");
//        queueInfo3.setDefaultRequeueRejected(false);
//        queueInfo3.setExposeListenerChannel(true);
//        List<RabbitMQQueueInfo> queueInfoList3 = new ArrayList<>();
//        queueInfoList3.add(queueInfo3);
//        mqSetting3.setQueueInfo(queueInfoList3);
//
//
//        RabbitMQSetting mqSetting4 = new RabbitMQSetting();
//        mqSetting4.setApplicationId("100400");
//        mqSetting4.setApplicationName("金多多");
//        mqSetting4.setModularId("200400");
//        mqSetting4.setModularName("考勤");
//
//        RabbitMQQueueInfo queueInfo4 = new RabbitMQQueueInfo();
//        queueInfo4.setAutoDelete("false");
//        queueInfo4.setDurable("true");
//        queueInfo4.setExclusive("false");
//        queueInfo4.setName("lichenpengQueue");
//        queueInfo4.setConcurrentConsumers(1);
//        queueInfo4.setMaxConcurrentConsumers(5);
//        queueInfo4.setAcknowledgeMode("AUTO");
//        queueInfo4.setDefaultRequeueRejected(false);
//        queueInfo4.setExposeListenerChannel(true);
//        List<RabbitMQQueueInfo> queueInfoList4 = new ArrayList<>();
//        queueInfoList4.add(queueInfo4);
//        mqSetting4.setQueueInfo(queueInfoList4);
//
//
//        list.add(mqSetting1);
//        list.add(mqSetting2);
//        list.add(mqSetting3);
//        list.add(mqSetting4);
//
//
//
//
//
//    /* 从数据库里面获取  RabbitMQ的队列、交换机、消费者信息， 得到集合  List<RabbitMQInfo>。
//    * 遍历集合 List<RabbitMQInfo>  每条数据创建一个 simpleListenerContainer，配置相关信息然后放入 containerList 集合中 Map key -> 为系统名称+" - "+模块名称，  Map value -> 为simpleListenerContainer
//    * */
//
//
//    //循环配置db
//    for(int i=0 ; i < list.size() ; i++ ){
//        //循环配置里面的  队列信息 List
//
////        List<SimpleMessageListenerContainer> containerList = new ArrayList<>();
//
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        for(int j=0 ; j < list.get(i).getQueueInfo().size() ; j++){
//
//            RabbitMQQueueInfo queueInfo = list.get(i).getQueueInfo().get(j);
//            Queue queue = new Queue(queueInfo.getName(),Boolean.parseBoolean(queueInfo.getDurable()), Boolean.parseBoolean(queueInfo.getExclusive()),Boolean.parseBoolean(queueInfo.getAutoDelete()),queueInfo.getArguments());
//            rabbitAdmin.declareQueue(queue);
//            container.addQueues(queue);
//
//            container.setConcurrentConsumers(queueInfo.getConcurrentConsumers());
//            container.setMaxConcurrentConsumers(queueInfo.getMaxConcurrentConsumers());
//
//            //设置是否重回队列
//            container.setDefaultRequeueRejected(queueInfo.isDefaultRequeueRejected());
//            //设置自动签收
//            if( AcknowledgeMode.AUTO.equals(queueInfo.getAcknowledgeMode())){
//                container.setAcknowledgeMode(AcknowledgeMode.AUTO);
//            }
//            if(AcknowledgeMode.MANUAL.equals(queueInfo.getAcknowledgeMode())){
//                container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//            }
//            if(AcknowledgeMode.NONE.equals(queueInfo.getAcknowledgeMode())){
//                container.setAcknowledgeMode(AcknowledgeMode.NONE);
//            }
//            //设置监听外露
//            container.setExposeListenerChannel(queueInfo.isExposeListenerChannel());
//
//
//
//            //设置消费端标签策略
//            container.setConsumerTagStrategy(new ConsumerTagStrategy() {
//                @Override
//                public String createConsumerTag(String queue) {
//                    return queue + "_" + UUID.randomUUID().toString();
//                }
//            });
//            //设置消息监听
//            container.setMessageListener(new ChannelAwareMessageListener() {
//                @Override
//                public void onMessage(Message message, Channel channel) throws Exception {
//                    String msg = new String(message.getBody(), "utf-8");
//                    System.out.println("-----------消费者：" + msg);
//                }
//            });
//            //将某个系统的某个队列加入监听列表中
////            containerList.add(container);
//        }
//        //添加每个系统的队列监听器
////        concurrentContainer.put(list.get(i).getApplicationId(),containerList);
//    }
//
//
//
//
//    log.info("concurrentContainer   -----"+ JSON.toJSONString(concurrentContainer));
//    return concurrentContainer ;
//    }
//}
//
//
//
//
//
//
//
//






















































//
package com.dijiang.staff.config;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dijiang.common.entity.RabbitQueueInfo;
import com.dijiang.staff.service.impl.RabbitQueueInfoServiceImpl;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
/* version：  0.0.2
 *  description： 创建 一个  SimpleMessageListenerContainer 容器集合，每个容器监听一个队列。该队列代表一个系统，
 * */



@Slf4j
@Configuration
public class RabbitMQConfig2 implements Serializable {


    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private RabbitQueueInfoServiceImpl rabbitQueueInfoService;

    public static Map<String,List<SimpleMessageListenerContainer>> containerMap  = new HashMap<>();

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("101.132.143.228:5672");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        System.err.println("RabbitAdmin启动了。。。");
        //设置启动spring容器时自动加载这个类(这个参数现在默认已经是true，可以不用设置)
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }


    /*
     *     简单消息监听容器
     *     1.  优化：从数据库里面查出MQ的配置信息，然后放到监听容器里面
     */
    @Bean
    public Map<String,List<SimpleMessageListenerContainer>> messageContainer(ConnectionFactory connectionFactory) {

        int count = 0;
        List<RabbitQueueInfo> list = rabbitQueueInfoService.allList();
        Map<String, List<RabbitQueueInfo>> collect = list.stream().collect(Collectors.groupingBy(RabbitQueueInfo::getApplicationId));
        log.info("分组后的  信息    {}",JSON.toJSONString(collect));




        for(Map.Entry<String,List<RabbitQueueInfo>>  entry : collect.entrySet() ){
            // 按 applicationId 分组后队列配置信息
            String key = entry.getKey();
            List<SimpleMessageListenerContainer> value = new ArrayList<>();


            List<RabbitQueueInfo> entryValue   =  entry.getValue();


            for (int i = 0; i < entryValue.size(); i++) {
                SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);

                RabbitQueueInfo queueInfo = entryValue.get(i);
                Queue queue = new Queue(queueInfo.getName(), queueInfo.isDurable(), queueInfo.isExclusive(), queueInfo.isAutoDelete(), argumentConvert(queueInfo.getArguments()));
                rabbitAdmin.declareQueue(queue);
                container.addQueues(queue);

                container.setConcurrentConsumers(queueInfo.getConcurrentConsumers());
                container.setMaxConcurrentConsumers(queueInfo.getMaxConcurrentConsumers());
                container.setDefaultRequeueRejected(false);

                if (AcknowledgeMode.AUTO.equals(queueInfo.getAcknowledgeMode())) {
                    container.setAcknowledgeMode(AcknowledgeMode.AUTO);
                }
                if (AcknowledgeMode.NONE.equals(queueInfo.getAcknowledgeMode())) {
                    container.setAcknowledgeMode(AcknowledgeMode.NONE);
                }
                if (AcknowledgeMode.MANUAL.equals(queueInfo.getAcknowledgeMode())) {
                    container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
                }

                container.setExposeListenerChannel(true);

                //设置消费端标签策略
                container.setConsumerTagStrategy(new ConsumerTagStrategy() {
                    @Override
                    public String createConsumerTag(String queue) {
                        return queue + "_" + UUID.randomUUID().toString();
                    }
                });
                //设置消息监听
                container.setMessageListener(new ChannelAwareMessageListener() {
                    @Override
                    public void onMessage(Message message, Channel channel) throws Exception {
                        String msg = new String(message.getBody(), "utf-8");
                        System.out.println("-----------消费者：" + msg);
                    }
                });
                value.add(container);
                count += queueInfo.getConcurrentConsumers();
            }
                containerMap.put(key,value);
        }





        //开启 SimpleMessageListenerContainer
        for(Map.Entry<String,List<SimpleMessageListenerContainer>> entry : containerMap.entrySet()){
            for(SimpleMessageListenerContainer container :  entry.getValue()){
                 container.start();
                 log.info("正在开启 SimpleMessageListenerContainer  【{}】 ",entry.getKey());
            }
        }

        log.info("初始化 MQ 消费者个数 total  【{}】" , count);
        log.info(" SimpleMessageListenerContainer 列表 "+ JSON.toJSONString(containerMap));
        return containerMap;
    }


    private Map<String, Object> argumentConvert(String json) {
        if (StringUtil.isNotBlank(json)) {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(json);
            Iterator it = jsonObject.entrySet().iterator();
            Map<String, Object> data = new HashMap<>();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
                data.put(entry.getKey(), entry.getValue());
            }
            return data;
        } else {
            return null;
        }
    }
}












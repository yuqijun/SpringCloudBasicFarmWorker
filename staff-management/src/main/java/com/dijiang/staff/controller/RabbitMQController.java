//package com.dijiang.staff.controller;
//
//import com.dijiang.common.controller.BaseController;
//import com.dijiang.common.entity.RabbitMQQueueInfo;
//import com.dijiang.common.entity.RabbitMQSetting;
//import com.dijiang.common.entity.ResponseResult;
//import com.dijiang.staff.config.RabbitMQConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/api/rabbitmq")
//@Slf4j
//public class RabbitMQController extends BaseController {
//
//
//    @Autowired
//    private RabbitAdmin rabbitAdmin;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    /* 传入接入系统的RabbitMQ 设置参数和系统id编号 */
//    @PostMapping("/addSystemRabbitMQSetting")
//    public ResponseResult addSystemRabbitMQSetting(@RequestBody RabbitMQSetting mqSetting){
//
//        boolean mark = false;
//        /* 获取 RabbitMQConfig Bean 里面的监听器容器 -> 新增队列 -> 新增监听者 */
//        RabbitMQQueueInfo queueInfo = mqSetting.getQueueInfo().get(0);
//        /* 检查一下队列有没有重名 */
//        Queue queue = new Queue(queueInfo.getName(),Boolean.parseBoolean(queueInfo.getDurable()), Boolean.parseBoolean(queueInfo.getExclusive()),Boolean.parseBoolean(queueInfo.getAutoDelete()),queueInfo.getArguments());
//        /* 很重要 意味创建一个队列 */
//        rabbitAdmin.declareQueue(queue);
//        try {
//            RabbitMQConfig.container.addQueues(queue);
//            mark=true;
//            rabbitTemplate.convertAndSend(queue.getName(),"动态新增队列初始消息---------");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return !mark?FailResult("添加新队列失败"):SuccessResult("添加新队列成功");
//    }
//
//
//    @PostMapping("/addSystemRabbitMQSetting2")
//    public ResponseResult addSystemRabbitMQSetting_version2(@RequestBody RabbitMQSetting mqSetting){
//
////        boolean mark = false;
////        /* 获取 RabbitMQConfig Bean 里面的监听器容器 -> 新增队列 -> 新增监听者 */
////        RabbitMQQueueInfo queueInfo = mqSetting.getQueueInfo();
////        /* 检查一下队列有没有重名 */
////        Queue queue = new Queue(queueInfo.getName(),Boolean.parseBoolean(queueInfo.getDurable()), Boolean.parseBoolean(queueInfo.getExclusive()),Boolean.parseBoolean(queueInfo.getAutoDelete()),queueInfo.getArguments());
////        /* 很重要 意味创建一个队列 */
////        rabbitAdmin.declareQueue(queue);
////        try {
////            RabbitMQConfig.container.addQueues(queue);
////            mark=true;
////            rabbitTemplate.convertAndSend(queue.getName(),"动态新增队列初始消息---------");
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return !mark?FailResult("添加新队列失败"):SuccessResult("添加新队列成功");
//
//        /* 判断一下数据库中是否有重复的配置
//        *
//        * */
//
//
//
//        return SuccessResult();
//    }
//}

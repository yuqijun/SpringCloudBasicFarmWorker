//package com.dijiang.staff.config;
//
//
//import java.util.UUID;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.amqp.support.ConsumerTagStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.rabbitmq.client.Channel;
//
//@Slf4j
//@Configuration
//public class RabbitMQConfig {
//
//    public static  SimpleMessageListenerContainer container = null;
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
//    @Bean
//    public TopicExchange exchange001() {
//        return new TopicExchange("topic001", true, false);
//    }
//
//    @Bean
//    public Queue queue001() {
//        return new Queue("queue001", true);//队列持久化
//    }
//
//    @Bean
//    public Binding binding001() {
//        return BindingBuilder.bind(queue001()).to(exchange001()).with("spring.*");
//    }
//
//    @Bean
//    public TopicExchange exchange002() {
//        return new TopicExchange("topic002", true, false);
//    }
//
//    @Bean
//    public Queue queue002() {
//        return new Queue("queue002", true);//队列持久化
//    }
//
//    @Bean
//    public Binding binding002() {
//        return BindingBuilder.bind(queue002()).to(exchange002()).with("rabbit.*");
//    }
//
//    @Bean
//    public TopicExchange exchange003() {
//        return new TopicExchange("topic003", true, false);
//    }
//
//    @Bean
//    public Queue queue003() {
//        return new Queue("queue003", true);//队列持久化
//    }
//
//    @Bean
//    public Binding binding003() {
//        return BindingBuilder.bind(queue003()).to(exchange003()).with("mq.*");
//    }
//
//    @Bean
//    public Queue queue_image() {
//        return new Queue("image_queue", true);//队列持久化
//    }
//
//    @Bean
//    public Queue queue_pdf() {
//        return new Queue("pdf_queue", true);//队列持久化
//    }
//
//    /*
//     *     简单消息监听容器
//     *     1.  优化：从数据库里面查出MQ的配置信息，然后放到监听容器里面
//     */
//    @Bean
//    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//
//
//        //查数据库获取 MQ配置 List  循环list创建 一个Queue集合 然后转成数组，把它放到监听容器里面。
//
//        //同时监听多个队列
//        container.setQueues(queue001(), queue002(), queue003(), queue_image(), queue_pdf());
//
//
//        //设置当前的消费者数量
//        container.setConcurrentConsumers(1);
//        container.setMaxConcurrentConsumers(5);
//        //设置是否重回队列
//        container.setDefaultRequeueRejected(false);
//        //设置自动签收
//        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        //设置监听外露
//        container.setExposeListenerChannel(true);
//
//        //设置消费端标签策略
//        container.setConsumerTagStrategy(new ConsumerTagStrategy() {
//            @Override
//            public String createConsumerTag(String queue) {
//                return queue + "_" + UUID.randomUUID().toString();
//            }
//        });
//        //设置消息监听
//        container.setMessageListener(new ChannelAwareMessageListener() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                String msg = new String(message.getBody(), "utf-8");
//                System.out.println("-----------消费者：" + msg);
//            }
//        });
//
//
//
//
//
//        RabbitMQConfig.container = container;
//        log.info("container - - - - - - f-  "+ JSON.toJSONString(container));
//        return RabbitMQConfig.container;
//    }
//}
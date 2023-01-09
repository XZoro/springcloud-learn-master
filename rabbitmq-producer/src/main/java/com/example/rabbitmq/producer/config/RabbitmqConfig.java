package com.example.rabbitmq.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xzq
 * @date 2023年01月09日 16:12
 */
@Configuration
public class RabbitmqConfig {
    /**
     * email队列
     */
    public static final String QUEUE_EMAIL = "queue_email";
    /**
     * sms队列
     */
    public static final String QUEUE_SMS = "queue_sms";
    /**
     * topics类型交换机
     */
    public static final String EXCHANGE_NAME = "topic.exchange";
    public static final String ROUTING_KEY_EMAIL = "topic.#.email.#";
    public static final String ROUTING_KEY_SMS = "topic.#.sms.#";

    /**
     * 声明交换机
     *
     * @return 交换机
     * @author xzq
     * @date 2023/1/9 16:16
     */
    @Bean(EXCHANGE_NAME)
    public Exchange exchange() {
        //durable(true) 持久化，mq重启之后交换机还在
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    /**
     * 声明email队列
     * new Queue(QUEUE_EMAIL,true,false,false)
     * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
     * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
     * exclusive  表示该消息队列是否只在当前connection生效,默认是false
     *
     * @return email队列
     * @author xzq
     * @date 2023/1/9 16:16
     */
    @Bean(QUEUE_EMAIL)
    public Queue emailQueue() {
        return new Queue(QUEUE_EMAIL);
    }

    /**
     * 声明sms队列
     *
     * @return sms队列
     * @author xzq
     * @date 2023/1/9 16:16
     */
    @Bean(QUEUE_SMS)
    public Queue smsQueue() {
        return new Queue(QUEUE_SMS);
    }

    /**
     * ROUTING_KEY_EMAIL队列绑定交换机，指定routingKey
     *
     * @param queue    队列
     * @param exchange 交换机
     * @return 绑定信息
     * @author xzq
     * @date 2023/1/9 16:19
     */
    @Bean
    public Binding bindingEmail(@Qualifier(QUEUE_EMAIL) Queue queue, @Qualifier(EXCHANGE_NAME) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_EMAIL).noargs();
    }

    /**
     * ROUTING_KEY_SMS队列绑定交换机，指定routingKey
     *
     * @param queue    队列
     * @param exchange 交换机
     * @return 绑定信息
     * @author xzq
     * @date 2023/1/9 16:19
     */
    @Bean
    public Binding bindingSms(@Qualifier(QUEUE_SMS) Queue queue, @Qualifier(EXCHANGE_NAME) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_SMS).noargs();
    }
}

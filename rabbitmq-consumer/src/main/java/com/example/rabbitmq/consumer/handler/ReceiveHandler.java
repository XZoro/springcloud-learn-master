package com.example.rabbitmq.consumer.handler;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xzq
 * @date 2023年01月09日 16:36
 */
@Component
public class ReceiveHandler {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "queue_email", durable = "true"),
                    exchange = @Exchange(value = "topic.exchange", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
                    key = {"topic.#.email.#", "email.*"}
            )
    )
    public void receivingEmail(String msg) {
        System.out.println(" [邮件服务] received : " + msg + "!");
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "queue_sms", durable = "true"),
                    exchange = @Exchange(value = "topic.exchange", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
                    key = {"topic.#.sms.#"}
            )
    )
    public void receivingSms(String msg) {
        System.out.println(" [短信服务] received : " + msg + "!");
    }
}

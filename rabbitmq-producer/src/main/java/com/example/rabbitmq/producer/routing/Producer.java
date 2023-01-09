package com.example.rabbitmq.producer.routing;

import com.example.rabbitmq.producer.util.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * routingKey模型
 * 生产者，向Exchange发送消息，发送消息时，会指定一个routing key。
 * @author xzq
 * @date 2023年01月09日 10:47
 */
public class Producer {

    private static final String EXCHANGE_NAME  = "test_direct_exchange";

    public static void main(String[] arg) throws Exception {
        //1、获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2、从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        //3、声明exchange，指定类型为direct（直接）
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //4、消息内容
        String message = "注册成功！请短信回复[T]退订";
        //5、向指定的队列中发送消息
        channel.basicPublish(EXCHANGE_NAME, "email", null, message.getBytes());
        System.out.println(" [生产者] Sent '" + message + "'");

        //6、关闭通道和连接
        channel.close();
        connection.close();
    }
}

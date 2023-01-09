package com.example.rabbitmq.producer.topics;

import com.example.rabbitmq.producer.util.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * topics模型
 * 生产者将消息发给broker，由交换机根据routing key来转发消息到指定的队列。
 * @author xzq
 * @date 2023年01月09日 10:47
 */
public class Producer {

    private static final String EXCHANGE_NAME  = "test_topic_exchange";

    public static void main(String[] arg) throws Exception {
        //1、获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2、从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        //3、声明exchange，指定类型为topic（匹配）
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        //4、消息内容
        String message = "这是一只行动迅速的橙色的兔子";
        //5、向指定的队列中发送消息
        channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());
        System.out.println(" [动物描述] Sent '" + message + "'");
        String message2 = "这是一只行动缓慢的粉红色的兔子";
        channel.basicPublish(EXCHANGE_NAME, "lazy.pink.rabbit", null, message2.getBytes());
        System.out.println(" [动物描述] Sent '" + message2 + "'");

        //6、关闭通道和连接
        channel.close();
        connection.close();
    }
}

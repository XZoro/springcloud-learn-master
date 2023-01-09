package com.example.rabbitmq.producer.routing;

import com.example.rabbitmq.producer.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * @author xzq
 * @date 2023年01月09日 11:11
 */
public class Receive2 {

    private static final String EXCHANGE_NAME  = "test_direct_exchange";
    /** 邮件队列 */
    private static final String QUEUE_NAME   = "direct_exchange_queue_email";

    public static void main(String[] arg) throws Exception {
        //1、获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2、从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        //3、声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //4、绑定队列到交换机, 同时指定需要订阅的routing key，可以指定多个
        //指定接收发送方指定routing key为email的消息
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "email");
        //5、定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                //body 即消息体
                String msg = new String(body);
                System.out.println(" [邮件服务] received : " + msg + "!");
            }
        };
        //5、监听队列，第二个参数：是否自动进行消息确认
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}

package com.example.rabbitmq.producer.fanout;

import com.example.rabbitmq.producer.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author xzq
 * @date 2023年01月09日 11:11
 */
public class Receive1 {

    private static final String EXCHANGE_NAME  = "test_fanout_exchange";
    /** 短信队列 */
    private static final String QUEUE_NAME   = "fanout_exchange_queue_sms";

    public static void main(String[] arg) throws Exception {
        //1、获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2、从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        //3、声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //4、绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        //5、 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //body 即消息体
                String msg = new String(body);
                System.out.println(" [短信服务] received : " + msg + "!");
            }
        };
        //5、监听队列，第二个参数：是否自动进行消息确认
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}

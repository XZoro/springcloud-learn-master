package com.example.rabbitmq.producer.work;

import com.example.rabbitmq.producer.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author xzq
 * @date 2023年01月09日 11:11
 */
public class Receive2 {

    private static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] arg) throws Exception {
        //1、获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2、从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        //3、声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //4、实现消费方法
        DefaultConsumer consumer = new DefaultConsumer(channel){
          public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
              //body 即消息体
              String msg = new String(body, "utf-8");
              System.out.println(" [消费者2] received : " + msg + "!");
          }
        };
        //5、监听队列，第二个参数：是否自动进行消息确认
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}

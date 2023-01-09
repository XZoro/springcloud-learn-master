package com.example.rabbitmq.producer.work;

import com.example.rabbitmq.producer.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author xzq
 * @date 2023年01月09日 10:47
 */
public class Producer {

    private static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] arg) throws Exception {
        //1、获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2、从连接中创建通道，使用通道才能完成消息相关的操作
        Channel channel = connection.createChannel();
        //3、声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 50; i++){
            //4、消息内容
            String message = "task.." + i;
            //5、向指定的队列中发送消息
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i*2);
        }
        //6、关闭通道和连接
        channel.close();
        connection.close();
    }
}

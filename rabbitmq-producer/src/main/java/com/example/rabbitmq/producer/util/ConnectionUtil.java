package com.example.rabbitmq.producer.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * @author xzq
 * @date 2023年01月09日 10:41
 */
public class ConnectionUtil {

    /**
     * 建立与RabbitMQ的连接
     *
     * @return Connection
     * @author xzq
     * @date 2023/1/9 10:55
     */
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //设置端口
        factory.setPort(5672);
        //设置账号信息：用户，密码
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory.newConnection();
    }
}

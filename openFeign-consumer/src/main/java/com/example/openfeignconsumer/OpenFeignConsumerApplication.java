package com.example.openfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 000061382
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OpenFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConsumerApplication.class, args);
    }

}

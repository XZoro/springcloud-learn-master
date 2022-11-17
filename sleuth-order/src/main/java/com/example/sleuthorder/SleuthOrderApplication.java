package com.example.sleuthorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 000061382
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SleuthOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthOrderApplication.class, args);
    }

}

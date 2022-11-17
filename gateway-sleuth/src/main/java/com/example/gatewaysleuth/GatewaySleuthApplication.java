package com.example.gatewaysleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 000061382
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySleuthApplication.class, args);
    }

}

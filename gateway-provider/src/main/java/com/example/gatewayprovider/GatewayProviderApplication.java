package com.example.gatewayprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayProviderApplication.class, args);
    }

}

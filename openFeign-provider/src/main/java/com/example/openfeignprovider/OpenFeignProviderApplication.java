package com.example.openfeignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 000061382
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OpenFeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignProviderApplication.class, args);
    }

}

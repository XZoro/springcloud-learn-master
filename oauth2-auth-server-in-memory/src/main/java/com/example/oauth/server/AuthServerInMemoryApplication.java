package com.example.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xzq
 * @date 2022年11月03日 15:25
 */
@SpringBootApplication
public class AuthServerInMemoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerInMemoryApplication.class, args);
    }
}

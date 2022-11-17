package com.example.seataorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example"})
@MapperScan("com.example.dao.mapper")
public class SeataOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataOrderApplication.class, args);
	}

}

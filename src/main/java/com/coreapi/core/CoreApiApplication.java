package com.coreapi.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = "com.coreapi")
@EnableFeignClients(basePackages = "com.coreapi.client")
public class CoreApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(CoreApiApplication.class, args);
    }

}

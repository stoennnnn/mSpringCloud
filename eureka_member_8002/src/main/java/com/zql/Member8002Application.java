package com.zql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 26725 on 2019/1/3.
 */
@SpringBootApplication
@EnableEurekaClient
public class Member8002Application {
    public static void main(String[] args) {
        SpringApplication.run(Member8002Application.class, args);
    }
}

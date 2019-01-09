package com.zql.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by 张启磊 on 2019-1-10.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class APPOrderImpl {
    public static void main(String[] args) {
        SpringApplication.run(APPOrderImpl.class, args);
    }
}

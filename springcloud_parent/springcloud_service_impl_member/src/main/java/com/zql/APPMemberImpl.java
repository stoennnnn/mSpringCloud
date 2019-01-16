package com.zql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 张启磊 on 2019-1-10.
 */
@SpringBootApplication
@EnableEurekaClient
public class  APPMemberImpl {
    public static void main(String[] args) {
        SpringApplication.run( APPMemberImpl.class,args);
    }
}

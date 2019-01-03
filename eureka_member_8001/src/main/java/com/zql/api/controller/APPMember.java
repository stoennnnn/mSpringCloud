package com.zql.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 26725 on 2018/12/24.
 */
@SpringBootApplication
@EnableEurekaClient
public class APPMember {
    public static void main(String[] args){
        SpringApplication.run(APPMember.class,args);
    }


}

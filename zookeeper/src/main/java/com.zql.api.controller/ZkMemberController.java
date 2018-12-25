package com.zql.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2018-12-25.
 * EnableDiscoveryClient 的作用是：如果使用zookeeper，connsul作为注册中心，则使用该注解注册服务
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ZkMemberController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/getmemeber")
    public String getmemeber(){
        return "member服务，端口号为："+port;
    }
    public static void main(String[] args) {
        SpringApplication.run(ZkMemberController.class,args);
    }

}

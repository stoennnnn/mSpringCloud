package com.zql.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-2.
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/getmemeber")
    public String getmemeber(){
        return "member服务，端口号为："+port;
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsulController.class,args);
    }

}

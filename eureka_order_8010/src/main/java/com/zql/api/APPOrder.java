package com.zql.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 26725 on 2018/12/24.
 */
@SpringBootApplication
@EnableEurekaClient  // EnableEurekaClient 打开erueka的注册服务
@EnableFeignClients    //开启feign服务
public class APPOrder {
    public static void main(String[] args) {
        SpringApplication.run(APPOrder.class,args);
    }


    /**
     * 解决找不到RestTemplate，应该把RestTemplate注册到SpringBoot容器中
     * @LoadBalance开启本地的负载均衡
     * @return
     */
    @Bean
   // @LoadBalanced
    //做本地负载均衡的时候关闭这个注解
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

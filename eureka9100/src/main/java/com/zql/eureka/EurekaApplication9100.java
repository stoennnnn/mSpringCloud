package com.zql.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 26725 on 2018/12/25.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication9100 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9100.class, args);
    }

}

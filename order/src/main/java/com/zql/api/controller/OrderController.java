package com.zql.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by 26725 on 2018/12/24.
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 订单服务调用会员服务
     * @return
     */
    @RequestMapping("/getorder")
    public String getOrder(){
        /**
         * 有两种方法调用
         * 1.直接，通过ip地址调用 http://127.0.0.1/getMember
         * 2.别名，通过在serviceId调用 http://com.zql.member/getMember
         * 如果以rest别名方式调用需要依赖 ribbon负载均衡器@LoadBalanced，
         * 它能让本地的RestTemplate请求拥有负载均衡的能力
         */
        String url = "http://com.zql.member/getMember";
        String forObject = restTemplate.getForObject(url, String.class);
        return "订单服务测试"+forObject;
    }
    /**
     * 服务发现
     * @return
     */
    @RequestMapping("/discoveryCilent")
    public List<ServiceInstance> discoveryCilent(){
        List<ServiceInstance> instances = discoveryClient.getInstances("zookeeper-member");
        return instances;
    }


}

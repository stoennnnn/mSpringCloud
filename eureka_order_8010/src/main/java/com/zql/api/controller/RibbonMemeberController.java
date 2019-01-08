package com.zql.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 手动实现ribbon负载均衡效果
 * Created by 26725 on 2019/1/3.
 */
@RestController
public class RibbonMemeberController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    private int reqCount = 1;
    @RequestMapping("/ribbon")
    public String ribbonMember(){

        //利用DiscoveryClient获取服务列表
        //计算出需要调用的服务端编号
        //获取编号对应的地址
        String url = getInstance();
        //利用restTemplate调用
        String object = restTemplate.getForObject(url + "/getMember", String.class);
        return object;

    }

    /**
     * 获取服务的ip和port
     * @return
     */
    public String getInstance(){
        List<ServiceInstance> instances = discoveryClient.getInstances("COM.ZQL.MEMBER");
        if(null ==instances &&instances.size()==0)
            return null;
        int repCount = instances.size();
        int serverIndex = reqCount % repCount;
        String url = instances.get(serverIndex).getUri().toString();
        return  url;
    }
}

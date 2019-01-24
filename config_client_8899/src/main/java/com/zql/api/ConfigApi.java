package com.zql.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-24.
 * @RefreshScope  手动刷新配置
 */
@RestController
@RefreshScope
public class ConfigApi {
    @Value("${config_test}")
    private String config_test;
    @RequestMapping("/configTest")
    public  String  getConfig(){
        return config_test;
    }
}

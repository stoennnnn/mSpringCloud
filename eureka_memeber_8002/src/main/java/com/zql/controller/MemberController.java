package com.zql.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 26725 on 2019/1/3.
 */
@RestController
public class MemberController {
    @Value("(${server.port}")
    private String port;

    @RequestMapping("/getMember")
    public  String getMember(){
        return "this is member test 端口号是："+port;
    }

}

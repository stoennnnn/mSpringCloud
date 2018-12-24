package com.zql.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 26725 on 2018/12/24.
 */
@RestController
public class MemberController {
    @RequestMapping("/getMember")
    public  String getMember(){
        return "this is member test";
    }

}

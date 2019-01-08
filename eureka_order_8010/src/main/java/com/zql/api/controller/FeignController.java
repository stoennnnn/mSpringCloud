package com.zql.api.controller;

import com.zql.api.feign.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-9.
 */
@RestController
public class FeignController {
    @Autowired
    private MemberApiFeign memberApiFeign;
    @RequestMapping("/feign")
    public String feignEnable(){
        return memberApiFeign.getMember();
    }
}

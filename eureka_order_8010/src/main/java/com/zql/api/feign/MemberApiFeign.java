package com.zql.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 张启磊 on 2019-1-8.
 */
@FeignClient(name = "COM.ZQL.MEMBER")
public interface MemberApiFeign {
    //feign 书写以springMVC接口的形式书写
    //name就是注册中心的注册名字，请求的地址就是接口的名字，直接copy过来
    @RequestMapping("/getMember")
    public  String getMember();
}

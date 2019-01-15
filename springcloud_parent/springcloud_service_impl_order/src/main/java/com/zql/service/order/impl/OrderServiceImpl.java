package com.zql.service.order.impl;

import com.zql.api.entity.UserEntity;
import com.zql.api.service.OrderService;
import com.zql.base.ResponseBase;
import com.zql.service.order.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-10.
 */
@RestController
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;
    @Override
    public String order2Member(String name) {
        UserEntity user = memberServiceFeign.getMember("woaini");
        return user.toString();
    }

    @Override
    public String order2MemberInfo(String msg) {
        ResponseBase responseBase = memberServiceFeign.getMemberInfo("woaini");
        return responseBase.toString();
    }
}

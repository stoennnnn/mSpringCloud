package com.zql.service.order.fallback;

import com.zql.api.entity.UserEntity;
import com.zql.base.BaseApiService;
import com.zql.base.ResponseBase;
import com.zql.service.order.feign.MemberServiceFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 张启磊 on 2019-1-25.
 */
@Component
public class MemberInfoFallback extends BaseApiService implements  MemberServiceFeign {
    @Override
    public UserEntity getMember(@RequestParam("name") String name) {
        return null;
    }

    @Override
    public ResponseBase getMemberInfo(@RequestParam("msg") String msg) {
        return super.setResultError("服务超时！");
    }


}

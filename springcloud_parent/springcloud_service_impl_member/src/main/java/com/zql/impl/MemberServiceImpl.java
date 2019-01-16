package com.zql.impl;

import com.zql.api.entity.UserEntity;
import com.zql.api.service.MemberService;
import com.zql.base.BaseApiService;
import com.zql.base.ResponseBase;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-9.
 */
@RestController
public class MemberServiceImpl  extends BaseApiService   implements MemberService    {
    @Override
    public UserEntity getMember( String name) {
        UserEntity user= new UserEntity();
        user.setName(name);
        user.setAge(25);
        return user;
    }

    /**
     * 接口延迟1.5s响应
     * @return
     */
    @Override
    public ResponseBase getMemberInfo(String msg) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.setResultSuccess(msg);
    }


}

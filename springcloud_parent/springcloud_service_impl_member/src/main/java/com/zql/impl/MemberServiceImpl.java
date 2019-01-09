package com.zql.impl;

import com.zql.api.entity.UserEntity;
import com.zql.api.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-9.
 */
@RestController
public class MemberServiceImpl implements MemberService {
    @Override
    public UserEntity getMember( String name) {
        UserEntity user= new UserEntity();
        user.setName(name);
        user.setAge(25);
        return user;
    }


}

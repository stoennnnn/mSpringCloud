package com.zql.service.order.feign;

import com.zql.api.service.MemberService;
import com.zql.service.order.fallback.MemberInfoFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by 张启磊 on 2019-1-10.
 */
@FeignClient(value="com-zql-member" ,fallback = MemberInfoFallback.class)
public interface MemberServiceFeign extends MemberService {
}

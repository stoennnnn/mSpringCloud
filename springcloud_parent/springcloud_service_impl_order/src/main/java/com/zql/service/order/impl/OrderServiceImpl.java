package com.zql.service.order.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zql.api.entity.UserEntity;
import com.zql.api.service.OrderService;
import com.zql.base.BaseApiService;
import com.zql.base.ResponseBase;
import com.zql.service.order.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-1-10.
 */
@RestController
public class OrderServiceImpl extends BaseApiService implements OrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;
    @Override
    public String order2Member(String name) {
        UserEntity user = memberServiceFeign.getMember("woaini");
        return user.toString();
    }
    /**
     *  测试feign超时配置
     *  解决雪崩效应:默认打开降级，熔断，隔离(线程池隔离)服务
     *  直接和fallback写在一起，同一个线程池
     * @param msg
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "getUserInfoHystrixFallback")
    @RequestMapping("/getUserInfoHystrix")
    public ResponseBase order2MemberInfo(String msg) {
        System.out.println("当前线程为："+Thread.currentThread().getName());
        memberServiceFeign.getMemberInfo("woaini");
        return super.setResultError(msg);
    }
    //fallback方法参数类型和个数要一致
    public ResponseBase getUserInfoHystrixFallback(String msg){
        return super.setResultError("请求人数人过多，服务降级，请稍后再试...");
    }

    /**
     * 把fallback写在单独的类，方便管理，在调用的时候才线程池隔离
     * @param msg
     * @return
     */
    @HystrixCommand
    @RequestMapping("/getUserInfoHystrix2")
    public ResponseBase order2MemberInfo2(String msg) {
        System.out.println("当前线程为："+Thread.currentThread().getName());
        memberServiceFeign.getMemberInfo("woaini");
        return super.setResultError(msg);
    }

    //没有解决雪崩效应的方法
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        System.out.println("当前线程为："+Thread.currentThread().getName());
        return super.setResultSuccess("没有解决雪崩效应的方法");
    }
}

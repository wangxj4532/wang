package com.base.wang.service.impl;

import com.base.wang.model.Role;
import com.base.wang.service.TestService;
import com.base.wang.util.EbeanUtil;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl  implements TestService{
    public String helloWorld() {
        return "hello world,你好 世界！！！";
    }

    public Role findById(Integer id){
        Role role= EbeanUtil.find(Role.class,1l);
        System.out.println("============================");
        return role;
    }
}

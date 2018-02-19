package com.base.wang.controller;

import com.base.wang.model.Role;
import com.base.wang.service.TestService;
import com.base.wang.util.PageReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping("/hello")
    public Object sayHello() {
        return testService.helloWorld();
    }
    @ResponseBody
    @RequestMapping("/findRoleById")
    public Role findRoleById()  {
        Role role= testService.findById(1);
        return  role;
    }
    @ResponseBody
    @RequestMapping("/findRoleById2")
    public PageReturn findRoleById2()  {
        Role role= testService.findById(1);
        return PageReturn.successData(role);
    }
}

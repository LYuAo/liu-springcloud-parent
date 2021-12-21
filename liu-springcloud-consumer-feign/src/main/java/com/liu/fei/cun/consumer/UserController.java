package com.liu.fei.cun.consumer;

import com.bdqn.pojo.User;
import com.bdqn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/liu/selectUser",method = RequestMethod.GET)
    public Object selectUser(){
         return deptService.selectUser();
    }
    @RequestMapping(value = "/liu/addUser")
    public int add(){
        User user=new User();
        user.setAge(17);
        user.setEmail("20999");
        user.setName("sas");
        user.setId(12);
        return deptService.add(user);
    }
    @RequestMapping(value = "/liu/userName/{id}")
    public User userName(@PathVariable("id") long id){
        return deptService.userName(id);
    }
    //让注册进来的微服务,获取一些消息
    @RequestMapping(value = "/liu/discoveryClient")
    public Object discoveryClient() {
        return deptService.discoveryClient();
    }
}

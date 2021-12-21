package com.bdqn.service;

import com.bdqn.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
//value表示调取的服务名
//这里将hystrix提取到接口层面
@FeignClient(value = "PROVIDER",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptService {
    @RequestMapping(value = "/liu/selectUser",method = RequestMethod.GET)
    public List<User> selectUser();
    @RequestMapping(value = "/liu/addUser")
    public int add(User user);
    @RequestMapping(value = "/liu/discoveryClient")
    public Object discoveryClient() ;
    @GetMapping("/liu/userName/{id}")
    public User userName(@PathVariable("id") long id);
}

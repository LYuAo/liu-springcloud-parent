package com.liu.pro.controlller;

import com.bdqn.pojo.User;
import com.liu.pro.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    //获取一些配置的信息,得到具体的服务
    @Autowired
    private DiscoveryClient client;
    // getLogger内调用slf4j-log4j.jar的StaticLoggerBinder类的getLogger，获取对应的log4j
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/liu/selectUser",method = RequestMethod.GET)

    public Object selectUser(){
        return userService.selectUser();
    }
    @RequestMapping(value = "/liu/addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @RequestMapping(value = "/liu/userName/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hystrixUserName")
    public Object userName(@PathVariable("id") int id){
        User  user = null;
        try {
            user = userService.userName(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user==null){
              throw  new RuntimeException();
          }
        return user;
    }
    public Object hystrixUserName(@PathVariable("id") int id){
        return new User().setId(0).setEmail("...@...qq.com").setName("查无此人").setAge(0).setSource("MySQL is NULL");
    }
    //让注册进来的微服务,获取一些消息
    @RequestMapping(value = "/liu/discoveryClient")
    public Object discoveryClient(){
        //获取微服务列表的清单
        List<String> list=client.getServices();
        System.out.println("discovery=>client:"+list);
        //得到一个具体的服务信息通过具体的微服务id,applicationName
        List<ServiceInstance> instances=client.getInstances("PROVIDER");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+"\t"+
                    instance.getUri()+"\t" +
                    instance.getPort()+"\t"+
                    instance.getServiceId()+"\t"+
                    instance.getMetadata());
        }
        return this.client;
    }
}

package com.liu.pro.controlller;

import com.bdqn.pojo.User;
import com.liu.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DiscoveryClient client;   //获取一些配置的信息,得到具体的服务
    @RequestMapping(value = "/liu/selectUser",method = RequestMethod.GET)
    public Object selectUser(){
        return userService.selectUser();
    }
    @RequestMapping(value = "/liu/addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @RequestMapping(value = "/liu/userName/{id}",method = RequestMethod.GET)
    public Object userName(@PathVariable int id){
        return userService.userName(id);
    }


    //让注册进来的微服务,获取一些消息
    @RequestMapping(value = "/liu/discoveryClient")
    public Object discoveryClient(){
        //获取微服务列表的清单
        List<String> list=client.getServices();
        System.out.println("discovery=>client:"+list);
        //得到一个具体的服务信息通过具体的微服务id,applicationName 信息
        List<ServiceInstance> instances=client.getInstances("PROVIDER");
        for (ServiceInstance instance : instances) {
              System.out.println(instance.getHost()+"\t"+
                      instance.getUri()+"\t" +
                      instance.getPort()+"\t"+
                      instance.getServiceId()+"\t"+
                      instance.getMetadata());
        }
        //返回当前服务信息
        return this.client;
    }
}

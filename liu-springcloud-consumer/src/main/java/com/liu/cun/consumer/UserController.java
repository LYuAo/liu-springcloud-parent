package com.liu.cun.consumer;

import com.bdqn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    
    private static final String REST_URL_PERFIX="http://PROVIDER";


    @RequestMapping(value = "/helloSpringCould/select",method = RequestMethod.GET)
    public Object test1(){
         return restTemplate.getForObject(REST_URL_PERFIX+"/liu/selectUser",List.class);
    }
    @RequestMapping(value = "/helloSpringCould/addUser")
    public int test2(){
        User user=new User();
        user.setAge(17);
        user.setEmail("20999");
        user.setName("sas");
        user.setId(12);
        return restTemplate.postForObject(REST_URL_PERFIX+"/liu/addUser",user,Integer.class);
    }
    @RequestMapping(value = "/helloSpringCould/userName/{id}")
    public User test3(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_URL_PERFIX+"/liu/userName/"+id,User.class);
    }
    //让注册进来的微服务,获取一些消息
    @RequestMapping(value = "/liu/discoveryClient")
    public Object discoveryClient() {
        return restTemplate.getForObject(REST_URL_PERFIX+"/liu/discoveryClient",Object.class);
    }
}

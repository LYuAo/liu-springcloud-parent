package com.bdqn.service;

import com.bdqn.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;

import java.util.ArrayList;
import java.util.List;
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public List<User> selectUser() {
                List<User> list=new ArrayList<User>();
                list.add(new User().setId(0).setEmail("...@...qq.com").setName("LIST查无此人").setAge(0).setSource("MySQL is NULL"));
                return list;
            }

            @Override
            public int add(User user) {
                return 0;
            }

            @Override
            public Object discoveryClient() {
                return null;
            }

            @Override
            public User userName(long id) {
                return new User().setId(0).setEmail("...@...qq.com").setName("查无此人").setAge(0).setSource("MySQL is NULL");
            }
        };
    }
}

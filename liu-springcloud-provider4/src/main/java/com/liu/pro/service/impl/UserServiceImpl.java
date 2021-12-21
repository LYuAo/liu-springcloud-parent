package com.liu.pro.service.impl;

import com.bdqn.pojo.User;
import com.liu.pro.dao.UserDao;
import com.liu.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;



    public List<User> selectUser() {
        return userDao.selectUser();
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }


    public User userName(int id) {
        return userDao.userName(id);
    }
}

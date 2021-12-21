package com.liu.pro.service;

import com.bdqn.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectUser();
    public int addUser(User user);
    public User userName(int id);
}

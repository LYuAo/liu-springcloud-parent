package com.liu.pro.dao;

import com.bdqn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    public List<User> selectUser();
    public int addUser(User user);
    public User userName(int id);
}

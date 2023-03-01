package com.hs.dao;

import com.hs.entity.User;

import java.util.List;

public interface UserDao {
    User selectByPrimaryKey(Integer id);

    void update(User User);

    List<User> queryAll();

    int insert(User User);

    void del(Integer id);

}

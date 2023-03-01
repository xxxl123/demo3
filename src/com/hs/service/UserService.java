package com.hs.service;

import com.hs.dao.UserDao;
import com.hs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private com.hs.dao.UserDao UserDao;

    public User selectByPrimaryKey(Integer id) {
        return UserDao.selectByPrimaryKey(id);
    }

    public void update(User User) {
        UserDao.update(User);
    }

    public List<User> queryAll() {
        return UserDao.queryAll();
    }

    public int insert(User User) {
        return UserDao.insert(User);
    }

    public void del(Integer id) {
        UserDao.del(id);
    }

}

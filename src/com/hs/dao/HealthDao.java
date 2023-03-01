package com.hs.dao;

import com.hs.entity.Health;
import com.hs.entity.UserHealthvo;

import java.util.List;

public interface HealthDao {
    Health selectByPrimaryKey(Integer id);

    void update(Health Health);

    List<Health> queryAll();

    List<UserHealthvo> queryAlls();

    void insert(Health Health);

    void del(Integer id);

}

package com.hs.service;

import com.hs.dao.HealthDao;
import com.hs.entity.Health;
import com.hs.entity.PrescriptionVo;
import com.hs.entity.UserHealthvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {
    @Autowired
    private com.hs.dao.HealthDao HealthDao;

    public Health selectByPrimaryKey(Integer id) {
        return HealthDao.selectByPrimaryKey(id);
    }

    public void update(Health Health) {
        HealthDao.update(Health);
    }

    public List<Health> queryAll() {
        return HealthDao.queryAll();
    }

    public List<UserHealthvo> queryAlls() {
        return HealthDao.queryAlls();
    }

    public void insert(Health Health) {
        HealthDao.insert(Health);
    }

    public void del(Integer id) {
        HealthDao.del(id);
    }

}

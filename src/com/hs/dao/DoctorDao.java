package com.hs.dao;

import com.hs.entity.Admin;
import com.hs.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    Doctor selectByPrimaryKey(Integer id);

    void update(Doctor Doctor);

    List<Doctor> queryAll();

    int insert(Doctor Doctor);

    void del(Integer id);

    Admin adminLogin(Admin admin);

    List<Doctor> checkLogin(String username, String password);

    String selectIDByName(String username);
}

package com.hs.service;

import com.hs.dao.DoctorDao;
import com.hs.entity.Admin;
import com.hs.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private com.hs.dao.DoctorDao DoctorDao;


    public Doctor selectByPrimaryKey(Integer id) {
        return DoctorDao.selectByPrimaryKey(id);
    }

    public void update(Doctor Doctor) {
        DoctorDao.update(Doctor);
    }

    public List<Doctor> queryAll() {
        return DoctorDao.queryAll();
    }

    public  int insert(Doctor Doctor) {
        return DoctorDao.insert(Doctor);
    }

    public void del(Integer id) {
        DoctorDao.del(id);
    }

    public Boolean login(String username, String password, String type) {
        if (type.equals("doctor")) {
            List<Doctor> doctorList = DoctorDao.checkLogin(username,password);
            if (doctorList.isEmpty()) {
                return false;
            } else {
                return true;
            }

        } else {
            Admin admin = new Admin();
            admin.setPassword(password);
            admin.setUsername(username);
            if (this.DoctorDao.adminLogin(admin) == null) {
                return false;
            }
            return true;
        }
    }

    public String selectIDByName(String username) {
        return DoctorDao.selectIDByName(username);
    }
}

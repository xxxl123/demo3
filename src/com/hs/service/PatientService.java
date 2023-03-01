package com.hs.service;

import com.hs.dao.PatientDao;
import com.hs.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private com.hs.dao.PatientDao PatientDao;

    public Patient selectByPrimaryKey(Integer id) {
        return PatientDao.selectByPrimaryKey(id);
    }

    public void update(Patient Patient) {
        PatientDao.update(Patient);
    }

    public List<Patient> queryAll() {
        return PatientDao.queryAll();
    }

    public int insert(Patient Patient) {
        return PatientDao.insert(Patient);
    }

    public void del(Integer id) {
        PatientDao.del(id);
    }

}

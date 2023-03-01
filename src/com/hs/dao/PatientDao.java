package com.hs.dao;

import com.hs.entity.Patient;

import java.util.List;

public interface PatientDao {
    Patient selectByPrimaryKey(Integer id);

    void update(Patient Patient);

    List<Patient> queryAll();

    int insert(Patient Patient);

    void del(Integer id);

}

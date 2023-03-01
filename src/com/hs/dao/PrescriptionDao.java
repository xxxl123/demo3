package com.hs.dao;

import com.hs.entity.Prescription;
import com.hs.entity.PrescriptionVo;

import java.util.List;

public interface PrescriptionDao {
    Prescription selectByPrimaryKey(Integer id);

    void update(Prescription Prescription);

    List<Prescription> queryAll();

    void insert(Prescription Prescription);

    void del(Integer id);

    List<PrescriptionVo> queryAlls();
}

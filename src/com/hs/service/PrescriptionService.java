package com.hs.service;

import com.hs.dao.PrescriptionDao;
import com.hs.entity.Prescription;
import com.hs.entity.PrescriptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private com.hs.dao.PrescriptionDao PrescriptionDao;

    public Prescription selectByPrimaryKey(Integer id) {
        return PrescriptionDao.selectByPrimaryKey(id);
    }

    public void update(Prescription Prescription) {
        PrescriptionDao.update(Prescription);
    }

    public List<Prescription> queryAll() {
        return PrescriptionDao.queryAll();
    }

    public void insert(Prescription Prescription) {
        PrescriptionDao.insert(Prescription);
    }

    public void del(Integer id) {
        PrescriptionDao.del(id);
    }

    public List<PrescriptionVo> queryAlls() {
        return PrescriptionDao.queryAlls();
    }
}

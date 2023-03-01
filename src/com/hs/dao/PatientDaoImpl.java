package com.hs.dao;

import com.hs.entity.Patient;
import com.hs.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private com.hs.service.PatientService PatientService;
    @Override
    public Patient selectByPrimaryKey(Integer id) {
        String sql = "select * from Patient where id=?";
        RowMapper<Patient> rowMapper = new BeanPropertyRowMapper<Patient>(Patient.class);
        return jdbcTemplate.query(sql, rowMapper, id).get(0);
    }

    @Override
    public void update(Patient stu) {
        String sql = "update patient set name=?,birthday=?,gender=?,career=?,address=?,mobile=?,idcard=?,username=?,password=? where id=?";
        jdbcTemplate.update(sql,
                stu.getName(),
                stu.getBirthday(),
                stu.getGender(),
                stu.getCareer(),
                stu.getAddress(),
                stu.getMobile(),
                stu.getIdcard(),
                stu.getUsername(),
                stu.getPassword()
                , stu.getId()
        );
    }

    @Override
    public List<Patient> queryAll() {
        String sql = "select * from Patient";
        RowMapper<Patient> rowMapper = new BeanPropertyRowMapper<Patient>(Patient.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int insert(Patient stu) {
        int i=0;
        List<Patient> list = PatientService.queryAll();
        for (Patient user : list) {
            if(stu.getIdcard().equals(user.getIdcard())){
                i=1;
            }
        }
        if(i==0){
            String sql = "insert into patient(name,birthday,gender,career,address,mobile,idcard,username,password) values(?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,
                    stu.getName(),
                    stu.getBirthday(),
                    stu.getGender(),
                    stu.getCareer(),
                    stu.getAddress(),
                    stu.getMobile(),
                    stu.getIdcard(),
                    stu.getUsername(),
                    stu.getPassword()
            );
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public void del(Integer id) {
        String sql = "delete from  Patient where id=?";
        jdbcTemplate.update(sql,
                id
        );
    }

}

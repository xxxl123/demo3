package com.hs.dao;

import com.hs.entity.Admin;
import com.hs.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private com.hs.service.DoctorService DoctorService;
    @Override
    public Admin adminLogin(Admin admin) {
        String sql = "select * from admin where username=? and password=?";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<Admin>(Admin.class);
        List<Admin> query = jdbcTemplate.query(sql, rowMapper, admin.getUsername(), admin.getPassword());
        return query.isEmpty() ? null : query.get(0);
    }

    @Override
    public List<Doctor> checkLogin(String username, String password) {
        String sql = "select * from doctor where username=? and password=?";
        RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);
        return jdbcTemplate.query(sql, rowMapper,username,password);
    }

    @Override
    public String selectIDByName(String username) {
        String sql = "select id from doctor where username=?";
        RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);
        Doctor doctor = jdbcTemplate.query(sql,rowMapper,username).get(0);
        return doctor.getId().toString();
    }

    @Override
    public Doctor selectByPrimaryKey(Integer id) {
        String sql = "select * from Doctor where id=?";
        RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);
        return jdbcTemplate.query(sql, rowMapper, id).get(0);
    }

    @Override
    public void update(Doctor stu) {
        String sql = "update doctor set name=?,birthday=?,gender=?,dep=?,address=?,mobile=?,idcard=?,username=?,password=? where id=?";
        jdbcTemplate.update(sql,
                stu.getName(),
                stu.getBirthday(),
                stu.getGender(),
                stu.getDep(),
                stu.getAddress(),
                stu.getMobile(),
                stu.getIdcard(),
                stu.getUsername(),
                stu.getPassword(),
                stu.getId()
        );
    }

    @Override
    public List<Doctor> queryAll() {
        String sql = "select * from Doctor";
        RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int insert(Doctor stu) {
        int i=0;
        List<Doctor> list = DoctorService.queryAll();
        for (Doctor user : list) {
            if(stu.getIdcard().equals(user.getIdcard())){
                i=1;
            }
        }
        if(i==0){

            String sql = "insert into doctor(name,birthday,gender,dep,address,mobile,idcard,username,password) values(?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,
                    stu.getName(),
                    stu.getBirthday(),
                    stu.getGender(),
                    stu.getDep(),
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
        String sql = "delete from  Doctor where id=?";
        jdbcTemplate.update(sql,
                id
        );
    }

}

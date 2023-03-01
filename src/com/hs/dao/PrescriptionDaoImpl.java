package com.hs.dao;

import com.hs.entity.Prescription;
import com.hs.entity.PrescriptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDaoImpl implements PrescriptionDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Prescription selectByPrimaryKey(Integer id) {
        String sql = "select * from Prescription where id=?";
        RowMapper<Prescription> rowMapper = new BeanPropertyRowMapper<Prescription>(Prescription.class);
        return jdbcTemplate.query(sql, rowMapper, id).get(0);
    }

    @Override
    public void update(Prescription stu) {
        String sql = "update Prescription set  name=?,patientid=?,doctorid=?,inpatientnumber=?,predate=?,content=? where id=?";
        jdbcTemplate.update(sql,
                stu.getName(),
                stu.getPatientid(),
                stu.getDoctorid(),
                stu.getInpatientnumber(),
                stu.getPredate(),
                stu.getContent(),
                stu.getId()
        );
    }

    @Override
    public List<Prescription> queryAll() {
        String sql = "select * from Prescription";
        RowMapper<Prescription> rowMapper = new BeanPropertyRowMapper<Prescription>(Prescription.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void insert(Prescription stu) {
        String sql = "insert into Prescription(name,patientid,doctorid,inpatientnumber,predate,content)values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                stu.getName(),
                stu.getPatientid(),
                stu.getDoctorid(),
                stu.getInpatientnumber(),
                stu.getPredate(),
                stu.getContent()

        );
    }

    @Override
    public void del(Integer id) {
        String sql = "delete from  Prescription where id=?";
        jdbcTemplate.update(sql,
                id
        );
    }

    @Override
    public List<PrescriptionVo> queryAlls() {
        String sql="SELECT p.id,p.name,p.inpatientnumber,p.predate,p.content,p2.name patientid FROM prescription p ,patient p2 WHERE p.patientid=p2.id";
        RowMapper<PrescriptionVo> rowMapper = new BeanPropertyRowMapper<PrescriptionVo>(PrescriptionVo.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

}

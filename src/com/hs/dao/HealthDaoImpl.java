package com.hs.dao;

import com.hs.entity.Health;
import com.hs.entity.PrescriptionVo;
import com.hs.entity.UserHealthvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HealthDaoImpl implements HealthDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Health selectByPrimaryKey(Integer id) {
        String sql = "select * from Health where id=?";
        RowMapper<Health> rowMapper = new BeanPropertyRowMapper<Health>(Health.class);
        return jdbcTemplate.query(sql, rowMapper, id).get(0);
    }

    @Override
    public void update(Health stu) {
        String sql = "update Health set userid=?,msg=?,times=? where id=?";
        jdbcTemplate.update(sql,
                stu.getUserid(),
                stu.getMsg(),
                stu.getTimes()
                , stu.getId()
        );
    }

    @Override
    public List<Health> queryAll() {
        String sql = "select * from Health";
        RowMapper<Health> rowMapper = new BeanPropertyRowMapper<Health>(Health.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<UserHealthvo> queryAlls() {
        String sql = "SELECT h.id,h.msg,h.times,u.name,u.idcard,u.age,u.phone FROM health h,USER u where h.userid = u.id";
        RowMapper<UserHealthvo> rowMapper = new BeanPropertyRowMapper<UserHealthvo>(UserHealthvo.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void insert(Health stu) {
        String sql = "insert into Health(userid,msg,times)values(?,?,?)";
        jdbcTemplate.update(sql,
                stu.getUserid(),
                stu.getMsg(),
                stu.getTimes()
        );
    }

    @Override
    public void del(Integer id) {
        String sql = "delete from  Health where id=?";
        jdbcTemplate.update(sql,
                id
        );
    }

}

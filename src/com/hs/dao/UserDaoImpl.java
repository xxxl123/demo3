package com.hs.dao;

import com.hs.entity.Health;
import com.hs.entity.User;
import com.hs.entity.UserHealthvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private com.hs.service.UserService UserService;
    @Override
    public User selectByPrimaryKey(Integer id) {
        String sql = "select * from User where id=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.query(sql, rowMapper, id).get(0);

    }

    @Override
    public void update(User stu) {
        String sql = "update User set name=?,idcard=?,age=?,phone=? where id=?";
        jdbcTemplate.update(sql,
                stu.getName(),
                stu.getIdcard(),
                stu.getAge(),
                stu.getPhone()
                , stu.getId()
        );
    }

    @Override
    public List<User> queryAll() {
        String sql = "select * from User";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int insert(User stu) {
        int i=0;

        List<User> list = UserService.queryAll();
        for (User user : list) {
            if(stu.getIdcard().equals(user.getIdcard())){
                i=1;
            }
        }
        if(i==0){
            String sql = "insert into User(name,idcard,age,phone)values(?,?,?,?)";
            jdbcTemplate.update(sql,
                    stu.getName(),
                    stu.getIdcard(),
                    stu.getAge(),
                    stu.getPhone()
            );
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public void del(Integer id) {
        String sql = "delete from  User where id=?";
        jdbcTemplate.update(sql,
                id
        );
    }
}

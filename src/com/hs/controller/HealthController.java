package com.hs.controller;

import com.hs.entity.Health;
import com.hs.entity.User;
import com.hs.entity.UserHealthvo;
import com.hs.service.HealthService;
import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HealthController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private com.hs.service.HealthService HealthService;

    @Autowired
    private UserService userService;


    @RequestMapping("Healthtoadd")
    public String toadd(Integer id) {
        List<User> users = userService.queryAll();
        request.setAttribute("list", users);
        return "Health/add";
    }


    @RequestMapping("Healthtoupdate")
    public String toupdate(Integer id) {
        Health Health = this.HealthService.selectByPrimaryKey(id);
        request.setAttribute("v", Health);
        List<User> users = userService.queryAll();
        request.setAttribute("list", users);
        return "Health/update";
    }

    @RequestMapping("Healthupdate")
    public String update(Health Health) {
        this.HealthService.update(Health);
        return "redirect:Healthlist";
    }

    @RequestMapping("Healthdel")
    public String del(Integer id) {
        this.HealthService.del(id);
        return "redirect:Healthlist";
    }


    @RequestMapping("Healthadd")
    public String add(Health Health) {
        Health.setTimes(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        this.HealthService.insert(Health);
        System.out.println(Health);
        System.out.println(Health.toString());
        return "redirect:Healthlist";
    }

    @RequestMapping("Healthlist")
    public String list() {
        List<UserHealthvo> list = HealthService.queryAlls();
        //request.setAttribute("list", list);
//        List<UserHealthvo> userHealthvos = new ArrayList<>();
//        for (Health health : list) {
//            UserHealthvo userHealthvo = new UserHealthvo();
//            Integer userid = health.getUserid();
//            User user = userService.selectByPrimaryKey(userid);
//            userHealthvo.setUser(user);
//            userHealthvo.setHealth(health);
//            userHealthvos.add(userHealthvo);
//        }
        if (list.size() > 5) {//判断list长度
            List newList = list.subList(0, 5);//取前四条数据
            request.setAttribute("list", newList);
            return "Health/list";
        } else {
            request.setAttribute("list", list);
            return "Health/list";
        }
    }

    @RequestMapping("HealthlistbyId")
    public String list(Integer id) {
        List<UserHealthvo> list = HealthService.queryAlls();
//        List<UserHealthvo> userHealthvos = new ArrayList<>();
//        for (Health health : list) {
//            UserHealthvo userHealthvo = new UserHealthvo();
//            Integer userid = health.getUserid();
//            User user = userService.selectByPrimaryKey(userid);
//            userHealthvo.setUser(user);
//            userHealthvo.setHealth(health);
//            userHealthvos.add(userHealthvo);
//        }
        int length = list.size();
        Integer fpage = (id-1)*5;
        Integer bpage = fpage+5;
        int b2page = length-fpage;
        if (list.size() > fpage) {//判断list长度
            if(b2page>5){
                List newList = list.subList(fpage, bpage);//取前四条数据
                request.setAttribute("list", newList);
                return "Health/list";
            }else {
                List newList = list.subList(fpage, fpage+b2page);//取前四条数据
                request.setAttribute("list", newList);
                return "Health/list";
            }
        } else {
            return "Health/list";
        }
    }
}


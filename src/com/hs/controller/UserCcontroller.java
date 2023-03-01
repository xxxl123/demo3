package com.hs.controller;

import com.hs.dao.UserDaoImpl;
import com.hs.entity.User;
import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class UserCcontroller {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private com.hs.service.UserService UserService;
    public String tempvalue1="";

    @RequestMapping("Usertoadd")
    public String toadd(Integer id) {
        return "User/add";
    }


    @RequestMapping("Usertoupdate")
    public String toupdate(Integer id) {
        User User = this.UserService.selectByPrimaryKey(id);
        request.setAttribute("v", User);
        return "User/update";
    }

    @RequestMapping("Userupdate")
    public String update(User User) {
        this.UserService.update(User);
        return "redirect:Userlist";
    }
    @RequestMapping("Userdel")
    public String del(Integer id) {
        this.UserService.del(id);
        return "redirect:Userlist";
    }
    @RequestMapping("Useradd")
    public String add(User User) {
        if(this.UserService.insert(User)==0){
            tempvalue1="1";
        }
        return "redirect:Userlist";
    }
    @RequestMapping("Userlist")
    public String list() {
        List<User> list = UserService.queryAll();

        if(tempvalue1=="1"){
            request.setAttribute("tempvalue1","此人已被登记，请重新添加");
            tempvalue1="";
            return "User/add";
        }
        if (list.size() > 5) {//判断list长度
            List newList = list.subList(0, 5);//取前四条数据
            request.setAttribute("list", newList);
            return "User/list";
        } else {
            request.setAttribute("list", list);
            return "User/list";
        }
    }

    @RequestMapping("UserlistbyId")
    public String listbyId(Integer  id){
        List<User> list = UserService.queryAll();
        int length = list.size();
        Integer fpage = (id-1)*5;
        Integer bpage = fpage+5;
        int b2page = length-fpage;
        if (list.size() > fpage) {//判断list长度
            if(b2page>5){
                List newList = list.subList(fpage, bpage);//取前四条数据
                request.setAttribute("list", newList);
                return "User/list";
            }else {
                List newList = list.subList(fpage, fpage+b2page);//取前四条数据
                request.setAttribute("list", newList);
                return "User/list";
            }
        } else {
            return "User/list";
        }

    }
}

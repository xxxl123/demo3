package com.hs.controller;

import com.hs.entity.Doctor;
import com.hs.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private com.hs.service.DoctorService DoctorService;
    public String tempvalue1="";
    @RequestMapping("login")
    public String login(String username, String password, String type) {
        Boolean isLogin = this.DoctorService.login(username, password, type);
        if (isLogin) {
            if (type.equals("admin")) {
                return "admin_index";
            } else {
                request.getSession().setAttribute("doctor_session", username);
                return "doctor_index";
            }
        } else {
            request.setAttribute("msg", true);
            return "login";
        }
    }

    @RequestMapping("Doctortoadd")
    public String toadd(Integer id) {
        return "Doctor/add";
    }


    @RequestMapping("Doctortoupdate")
    public String toupdate(Integer id) {
        Doctor Doctor = this.DoctorService.selectByPrimaryKey(id);
        request.setAttribute("v", Doctor);
        return "Doctor/update";
    }

    @RequestMapping("Doctorupdate")
    public String update(Doctor Doctor) {
        this.DoctorService.update(Doctor);
        return "redirect:Doctorlist";
    }

    @RequestMapping("Doctordel")
    public String del(Integer id) {
        this.DoctorService.del(id);
        return "redirect:Doctorlist";
    }


    @RequestMapping("Doctoradd")
    public String add(Doctor Doctor) {
        //this.DoctorService.insert(Doctor);
        if(this.DoctorService.insert(Doctor)==0){
            tempvalue1="1";
        }
        return "redirect:Doctorlist";
    }

    @RequestMapping("Doctorlist")
    public String list() {
        List<Doctor> list = DoctorService.queryAll();
        request.setAttribute("list", list);
        if(tempvalue1=="1"){
            request.setAttribute("tempvalue1","此人已被登记，请重新添加");
            tempvalue1="";
            return "Doctor/add";
        }
        return "Doctor/list";
    }

}

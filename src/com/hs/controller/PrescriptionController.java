package com.hs.controller;

import com.hs.entity.*;
import com.hs.service.DoctorService;
import com.hs.service.PatientService;
import com.hs.service.PrescriptionService;
import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PrescriptionController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private com.hs.service.PrescriptionService PrescriptionService;

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;


    @RequestMapping("Prescriptiontoadd")
    public String toadd(Integer id) {
        List<Patient> users = patientService.queryAll();
        request.setAttribute("list", users);
        return "Prescription/add";
    }


    @RequestMapping("Prescriptiontoupdate")
    public String toupdate(Integer id) {
        Prescription Prescription = this.PrescriptionService.selectByPrimaryKey(id);
        request.setAttribute("v", Prescription);
        return "Prescription/update";
    }

    @RequestMapping("Prescriptionupdate")
    public String update(Prescription Prescription) {
        this.PrescriptionService.update(Prescription);
        return "redirect:Prescriptionlist";
    }

    @RequestMapping("Prescriptiondel")
    public String del(Integer id) {
        this.PrescriptionService.del(id);
        return "redirect:Prescriptionlist";
    }


    @RequestMapping("Prescriptionadd")
    public String add(Prescription Prescription) {
        String username = (String) request.getSession().getAttribute("doctor_session");
        Prescription.setPredate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String doctorid = doctorService.selectIDByName(username);
        Prescription.setDoctorid(Integer.parseInt(doctorid));
        this.PrescriptionService.insert(Prescription);
        return "redirect:Prescriptionlist";
    }

    @RequestMapping("Prescriptionlist")
    public String list() {
        List<PrescriptionVo> list = PrescriptionService.queryAlls();
        if (list.size() > 5) {//判断list长度
            List newList = list.subList(0, 5);//取前四条数据
            request.setAttribute("list", newList);
            return "Prescription/list";
        } else {
            request.setAttribute("list", list);
            return "Prescription/list";
        }
    }
    @RequestMapping("PrescriptionlistbyId")
    public String listbyId(Integer  id){
        List<PrescriptionVo> list = PrescriptionService.queryAlls();
        int length = list.size();
        Integer fpage = (id-1)*5;
        Integer bpage = fpage+5;
        int b2page = length-fpage;
        if (list.size() > fpage) {//判断list长度
            if(b2page>5){
                List newList = list.subList(fpage, bpage);//取前四条数据
                request.setAttribute("list", newList);
                return "Prescription/list";
            }else {
                List newList = list.subList(fpage, fpage+b2page);//取前四条数据
                request.setAttribute("list", newList);
                return "Prescription/list";
            }
        } else {
            return "Prescription/list";
        }

    }
}

package com.hs.controller;

import com.hs.entity.Doctor;
import com.hs.entity.Patient;
import com.hs.entity.Prescription;
import com.hs.entity.User;
import com.hs.service.PatientService;
import com.hs.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private com.hs.service.PatientService PatientService;
    @Autowired
    private com.hs.service.UserService UserService;
    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping("Patienttoadd")
    public String toadd(Integer id) {
        List<User> list = UserService.queryAll();
        request.setAttribute("list", list);
        return "Patient/add";
    }

    public String tempvalue1="";
    @RequestMapping("Patienttoupdate")
    public String toupdate(Integer id) {
        Patient Patient = this.PatientService.selectByPrimaryKey(id);
        request.setAttribute("v", Patient);
        return "Patient/update";
    }

    @RequestMapping("Patientupdate")
    public String update(Patient Patient) {
        this.PatientService.update(Patient);
        return "redirect:Patientlist";
    }

    @RequestMapping("Patientdel")
    public String del(Integer id) {
        List<Prescription> prescriptions = prescriptionService.queryAll();
        for (Prescription p : prescriptions) {
            if (p.getPatientid() == id) {
                this.prescriptionService.del(p.getId());
            }
        }
        this.PatientService.del(id);
        return "redirect:Patientlist";
    }


    @RequestMapping("Patientadd")
    public String add(Patient Patient) {
        if(this.PatientService.insert(Patient)==0){
            tempvalue1="1";
        }
        return "redirect:Patientlist";
    }

    @RequestMapping("Patientlist")
    public String list() {
        List<Patient> list = PatientService.queryAll();
        if(tempvalue1=="1"){
            request.setAttribute("tempvalue1","此人已被登记，请重新添加");
            tempvalue1="";
            return "Patient/add";
        }
        System.out.println(list.size());
        if (list.size() > 5) {//判断list长度
            List newList = list.subList(0, 5);//取前四条数据
            request.setAttribute("list", newList);
            return "Patient/list";
        } else {
            request.setAttribute("list", list);
            return "Patient/list";
        }

        //request.setAttribute("list", list);
        //return "Patient/list";
    }
    @RequestMapping("PatientlistbyId")
    public String listbyId(Integer  id){
        List<Patient> list = PatientService.queryAll();

        int length = list.size();
        Integer fpage = (id-1)*5;
        Integer bpage = fpage+5;
        int b2page = length-fpage;
        if (list.size() > fpage) {//判断list长度
            if(b2page>5){
                List newList = list.subList(fpage, bpage);//取前四条数据
                request.setAttribute("list", newList);
                return "Patient/list";
            }else {
                List newList = list.subList(fpage, fpage+b2page);//取前四条数据
                request.setAttribute("list", newList);
                return "Patient/list";
            }
        } else {
            return "Patient/list";
        }

    }


    @RequestMapping("PatientlistForDoctor")
    public String PatientlistForDoctor() {
        List<Patient> list = this.PatientService.queryAll();
        if (list.size() > 5) {//判断list长度
            List newList = list.subList(0, 5);//取前四条数据
            request.setAttribute("list", newList);
            return "DoctorOper/list";
        } else {
            request.setAttribute("list", list);
            return "DoctorOper/list";
        }
    }
    @RequestMapping("PatientlistbyIdForDoctor")
    public String listForDoctorbyId(Integer  id){
        List<Patient> list = PatientService.queryAll();
        int length = list.size();
        Integer fpage = (id-1)*5;
        Integer bpage = fpage+5;
        int b2page = length-fpage;
        if (list.size() > fpage) {//判断list长度
            if(b2page>5){
                List newList = list.subList(fpage, bpage);//取前四条数据
                request.setAttribute("list", newList);
                return "DoctorOper/list";
            }else {
                List newList = list.subList(fpage, fpage+b2page);//取前四条数据
                request.setAttribute("list", newList);
                return "DoctorOper/list";
            }
        } else {
            return "DoctorOper/list";
        }

    }


}

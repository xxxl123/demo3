package com.hs.entity;

public class Prescription {
    private Integer id;

    private String name;

    private Integer patientid;

    private Integer doctorid;

    private String inpatientnumber;

    private String predate;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getInpatientnumber() {
        return inpatientnumber;
    }

    public void setInpatientnumber(String inpatientnumber) {
        this.inpatientnumber = inpatientnumber == null ? null : inpatientnumber.trim();
    }

    public String getPredate() {
        return predate;
    }

    public void setPredate(String predate) {
        this.predate = predate == null ? null : predate.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
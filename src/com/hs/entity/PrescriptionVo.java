package com.hs.entity;

public class PrescriptionVo {


    private String id;

    private String name;

    private String patientid;

    private String inpatientnumber;

    private String predate;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getInpatientnumber() {
        return inpatientnumber;
    }

    public void setInpatientnumber(String inpatientnumber) {
        this.inpatientnumber = inpatientnumber;
    }

    public String getPredate() {
        return predate;
    }

    public void setPredate(String predate) {
        this.predate = predate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PrescriptionVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", patientid='" + patientid + '\'' +
                ", inpatientnumber='" + inpatientnumber + '\'' +
                ", predate='" + predate + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

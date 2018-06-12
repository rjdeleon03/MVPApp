package com.cpu.quikdata.Models;

import com.cpu.quikdata.Models.Generics.SimpleDate;

import java.util.Calendar;

public class FormInfo {
    private String orgName;
    private SimpleDate assessmentDate;
    private String sitio;
    private String barangay;
    private String city;
    private String province;
    private String interviewer;
    private String interviewerNo;

    public FormInfo(String orgName, SimpleDate assessmentDate, String sitio, String barangay, String city, String province, String interviewer, String interviewerNo) {
        this.orgName = orgName;
        this.assessmentDate = assessmentDate;
        this.sitio = sitio;
        this.barangay = barangay;
        this.city = city;
        this.province = province;
        this.interviewer = interviewer;
        this.interviewerNo = interviewerNo;
    }

    public FormInfo() {
        this.orgName = "";
        this.sitio = "";
        this.barangay = "";
        this.city = "";
        this.province = "";
        this.interviewer = "";
        this.interviewerNo = "";
        this.assessmentDate = new SimpleDate();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public SimpleDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(SimpleDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getInterviewerNo() {
        return interviewerNo;
    }

    public void setInterviewerNo(String interviewerNo) {
        this.interviewerNo = interviewerNo;
    }
}
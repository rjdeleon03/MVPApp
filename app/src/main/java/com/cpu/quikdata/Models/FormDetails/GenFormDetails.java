package com.cpu.quikdata.Models.FormDetails;

import com.cpu.quikdata.Models.Generics.SimpleDate;

public class GenFormDetails {
    private String orgName;
    private SimpleDate assessmentDate;
    private String sitio;
    private String barangay;
    private String city;
    private String province;
    private String interviewer;
    private String interviewerNo;
    private String infoSources;

    public GenFormDetails(String orgName, SimpleDate assessmentDate, String sitio, String barangay, String city, String province, String interviewer, String interviewerNo, String infoSources) {
        this.orgName = orgName;
        this.assessmentDate = assessmentDate;
        this.sitio = sitio;
        this.barangay = barangay;
        this.city = city;
        this.province = province;
        this.interviewer = interviewer;
        this.interviewerNo = interviewerNo;
        this.infoSources = infoSources;
    }

    public GenFormDetails() {
        this("", new SimpleDate(), "", "", "", "", "", "", "");
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

    public String getInfoSources() {
        return infoSources;
    }

    public void setInfoSources(String infoSources) {
        this.infoSources = infoSources;
    }
}

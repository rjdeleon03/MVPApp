package com.rjdeleon.mvp_app.Models;

import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;

public class FormInfo {
    private String orgName;
    private String assessmentDate;
    private String sitio;
    private String barangay;
    private String city;
    private String province;
    private String interviewer;
    private String interviewerNo;
    private GenInfo genInfo;

    public FormInfo(String orgName, String assessmentDate, String sitio, String barangay, String city, String province, String interviewer, String interviewerNo, GenInfo genInfo) {
        this.orgName = orgName;
        this.assessmentDate = assessmentDate;
        this.sitio = sitio;
        this.barangay = barangay;
        this.city = city;
        this.province = province;
        this.interviewer = interviewer;
        this.interviewerNo = interviewerNo;
        this.genInfo = genInfo;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public String getSitio() {
        return sitio;
    }

    public String getBarangay() {
        return barangay;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public String getInterviewerNo() {
        return interviewerNo;
    }

    public GenInfo getGenInfo() {
        return genInfo;
    }
}

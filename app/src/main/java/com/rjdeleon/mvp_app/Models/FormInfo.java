package com.rjdeleon.mvp_app.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;

public class FormInfo extends BaseObservable {
    private String orgName;
    private String assessmentDate;
    private String sitio;
    private String barangay;
    private String city;
    private String province;
    private String interviewer;
    private String interviewerNo;

    public FormInfo(String orgName, String assessmentDate, String sitio, String barangay, String city, String province, String interviewer, String interviewerNo) {
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
        this.assessmentDate = "";
        this.sitio = "";
        this.barangay = "";
        this.city = "";
        this.province = "";
        this.interviewer = "";
        this.interviewerNo = "";
    }

    @Bindable
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Bindable
    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @Bindable
    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    @Bindable
    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Bindable
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Bindable
    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    @Bindable
    public String getInterviewerNo() {
        return interviewerNo;
    }

    public void setInterviewerNo(String interviewerNo) {
        this.interviewerNo = interviewerNo;
    }
}

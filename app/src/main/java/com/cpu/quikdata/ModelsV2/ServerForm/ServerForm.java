package com.cpu.quikdata.ModelsV2.ServerForm;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;

/**
 * Represents a form item received from the server
 */
public class ServerForm {

    private String id;
    private String sitio;
    private String barangay;
    private String city;
    private String province;
    private QuestionItemModelDate assessmentDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public QuestionItemModelDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(QuestionItemModelDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }
}

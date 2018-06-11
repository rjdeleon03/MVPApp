package com.cpu.quikdata.Models;

public class DNCAListItem {

    private int id;
    private String sitio;
    private String barangay;
    private String city;
    private String province;
    private String assessment;

    public DNCAListItem(int id, String sitio, String barangay, String city, String province, String assessment) {
        this.id = id;
        this.sitio = sitio;
        this.barangay = barangay;
        this.city = city;
        this.province = province;
        this.assessment = assessment;
    }

    public int getId() {
        return id;
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

    public String getAssessment() {
        return assessment;
    }
}

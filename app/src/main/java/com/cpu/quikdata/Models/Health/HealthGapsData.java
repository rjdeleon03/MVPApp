package com.cpu.quikdata.Models.Health;

public class HealthGapsData {

    private String nearestHospital;
    private String servicesAvailable;
    private String servicesAcessibility;
    private String repHealthServices;

    public HealthGapsData(String nearestHospital, String servicesAvailable, String servicesAcessibility, String repHealthServices) {
        this.nearestHospital = nearestHospital;
        this.servicesAvailable = servicesAvailable;
        this.servicesAcessibility = servicesAcessibility;
        this.repHealthServices = repHealthServices;
    }

    public HealthGapsData() {
        this("", "", "", "");
    }

    public String getNearestHospital() {
        return nearestHospital;
    }

    public void setNearestHospital(String nearestHospital) {
        this.nearestHospital = nearestHospital;
    }

    public String getServicesAvailable() {
        return servicesAvailable;
    }

    public void setServicesAvailable(String servicesAvailable) {
        this.servicesAvailable = servicesAvailable;
    }

    public String getServicesAcessibility() {
        return servicesAcessibility;
    }

    public void setServicesAcessibility(String servicesAcessibility) {
        this.servicesAcessibility = servicesAcessibility;
    }

    public String getRepHealthServices() {
        return repHealthServices;
    }

    public void setRepHealthServices(String repHealthServices) {
        this.repHealthServices = repHealthServices;
    }
}

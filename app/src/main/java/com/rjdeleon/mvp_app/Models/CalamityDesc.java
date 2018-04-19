package com.rjdeleon.mvp_app.Models;

public class CalamityDesc {
    private String calamityType;
    private String dateOccurred;
    private String description;

    public CalamityDesc(String calamityType, String dateOccurred, String description) {
        this.calamityType = calamityType;
        this.dateOccurred = dateOccurred;
        this.description = description;
    }

    public String getCalamityType() {
        return calamityType;
    }

    public void setCalamityType(String calamityType) {
        this.calamityType = calamityType;
    }

    public String getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(String dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

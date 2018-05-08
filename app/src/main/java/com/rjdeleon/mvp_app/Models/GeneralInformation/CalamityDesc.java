package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;

public class CalamityDesc {
    private String calamityType;
    private SimpleDate dateOccurred;
    private String eventDescription;
    private String areaDescription;

    public CalamityDesc(String calamityType, SimpleDate dateOccurred, String eventDescription, String areaDescription) {
        this.calamityType = calamityType;
        this.dateOccurred = dateOccurred;
        this.eventDescription = eventDescription;
        this.areaDescription = areaDescription;
    }

    public CalamityDesc() {
        this.calamityType = "";
        this.dateOccurred = new SimpleDate();
        this.eventDescription = "";
        this.areaDescription = "";
    }

    public String getCalamityType() {
        return calamityType;
    }

    public void setCalamityType(String calamityType) {
        this.calamityType = calamityType;
    }

    public SimpleDate getDateOccurred() {
        return dateOccurred;
    }

    public void setDateOccurred(SimpleDate dateOccurred) {
        this.dateOccurred = dateOccurred;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }
}

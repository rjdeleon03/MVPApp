package com.rjdeleon.mvp_app.Models.Shelter;

public class ShelterCopingData {

    private String evacuationSitesLocation;
    private String howToCope;
    private String whenToGoHome;
    private String whatIfCantGoHome;

    public ShelterCopingData(String evacuationSitesLocation, String howToCope, String whenToGoHome, String whatIfCantGoHome) {
        this.evacuationSitesLocation = evacuationSitesLocation;
        this.howToCope = howToCope;
        this.whenToGoHome = whenToGoHome;
        this.whatIfCantGoHome = whatIfCantGoHome;
    }

    public ShelterCopingData() {
        this.evacuationSitesLocation = "";
        this.howToCope = "";
        this.whenToGoHome = "";
        this.whatIfCantGoHome = "";
    }

    public String getEvacuationSitesLocation() {
        return evacuationSitesLocation;
    }

    public void setEvacuationSitesLocation(String evacuationSitesLocation) {
        this.evacuationSitesLocation = evacuationSitesLocation;
    }

    public String getHowToCope() {
        return howToCope;
    }

    public void setHowToCope(String howToCope) {
        this.howToCope = howToCope;
    }

    public String getWhenToGoHome() {
        return whenToGoHome;
    }

    public void setWhenToGoHome(String whenToGoHome) {
        this.whenToGoHome = whenToGoHome;
    }

    public String getWhatIfCantGoHome() {
        return whatIfCantGoHome;
    }

    public void setWhatIfCantGoHome(String whatIfCantGoHome) {
        this.whatIfCantGoHome = whatIfCantGoHome;
    }
}

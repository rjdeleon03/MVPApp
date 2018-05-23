package com.rjdeleon.mvp_app.Models.FoodSecurity;

public class FoodGapsData {

    private String isAssistanceAppropriate;
    private String isAssistanceEnough;
    private String hasEqualAccess;
    private String wereAllConsidered;

    public FoodGapsData(String isAssistanceAppropriate, String isAssistanceEnough, String hasEqualAccess, String wereAllConsidered) {
        this.isAssistanceAppropriate = isAssistanceAppropriate;
        this.isAssistanceEnough = isAssistanceEnough;
        this.hasEqualAccess = hasEqualAccess;
        this.wereAllConsidered = wereAllConsidered;
    }

    public FoodGapsData() {
        this("", "", "", "");
    }

    public String getIsAssistanceAppropriate() {
        return isAssistanceAppropriate;
    }

    public void setIsAssistanceAppropriate(String isAssistanceAppropriate) {
        this.isAssistanceAppropriate = isAssistanceAppropriate;
    }

    public String getIsAssistanceEnough() {
        return isAssistanceEnough;
    }

    public void setIsAssistanceEnough(String isAssistanceEnough) {
        this.isAssistanceEnough = isAssistanceEnough;
    }

    public String getHasEqualAccess() {
        return hasEqualAccess;
    }

    public void setHasEqualAccess(String hasEqualAccess) {
        this.hasEqualAccess = hasEqualAccess;
    }

    public String getWereAllConsidered() {
        return wereAllConsidered;
    }

    public void setWereAllConsidered(String wereAllConsidered) {
        this.wereAllConsidered = wereAllConsidered;
    }
}

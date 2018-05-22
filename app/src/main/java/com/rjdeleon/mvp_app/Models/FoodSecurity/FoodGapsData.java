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
}

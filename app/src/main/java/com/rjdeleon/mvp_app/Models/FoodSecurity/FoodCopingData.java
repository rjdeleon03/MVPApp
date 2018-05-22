package com.rjdeleon.mvp_app.Models.FoodSecurity;

public class FoodCopingData {

    private String copingStrategies;

    public FoodCopingData(String copingStrategies) {
        this.copingStrategies = copingStrategies;
    }

    public FoodCopingData() {
        this("");
    }

    public String getCopingStrategies() {
        return copingStrategies;
    }

    public void setCopingStrategies(String copingStrategies) {
        this.copingStrategies = copingStrategies;
    }
}

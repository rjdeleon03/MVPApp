package com.cpu.quikdata.Models.Generics;

public class GenericCopingData {

    private String copingStrategies;

    public GenericCopingData(String copingStrategies) {
        this.copingStrategies = copingStrategies;
    }

    public GenericCopingData() {
        this("");
    }

    public String getCopingStrategies() {
        return copingStrategies;
    }

    public void setCopingStrategies(String copingStrategies) {
        this.copingStrategies = copingStrategies;
    }
}

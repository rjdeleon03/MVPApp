package com.rjdeleon.mvp_app.Models.Wash;

public class WaterLevelRemarksTuple {

    public enum WaterLevel {
        LEVEL_1,
        LEVEL_2,
        LEVEL_3
    }

    public WaterLevel waterLevel;
    public String remarks;

    public WaterLevelRemarksTuple(WaterLevel waterLevel, String remarks) {
        this.waterLevel = waterLevel;
        this.remarks = remarks;
    }

    public WaterLevelRemarksTuple() {
        this(WaterLevel.LEVEL_1, "");
    }
}

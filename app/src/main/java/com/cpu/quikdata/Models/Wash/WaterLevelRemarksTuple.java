package com.cpu.quikdata.Models.Wash;

public class WaterLevelRemarksTuple {

    public enum WaterLevel {
        LEVEL_1,
        LEVEL_2,
        LEVEL_3;

        public static WaterLevel fromString(String str) {
            switch(str) {
                case "Level 2":
                    return LEVEL_2;
                case "Level 3":
                    return LEVEL_3;
                default:
                    return LEVEL_1;
            }
        }
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

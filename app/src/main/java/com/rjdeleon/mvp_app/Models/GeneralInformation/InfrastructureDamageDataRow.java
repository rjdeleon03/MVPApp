package com.rjdeleon.mvp_app.Models.GeneralInformation;

public class InfrastructureDamageDataRow {
    private InfrastructureDamageData.InfraType infraType;
    private int damaged;
    private boolean isFunctional;
    private String remarks;

    public InfrastructureDamageDataRow(InfrastructureDamageData.InfraType infraType, int damaged, boolean isFunctional, String remarks) {
        this.infraType = infraType;
        this.damaged = damaged;
        this.isFunctional = isFunctional;
        this.remarks = remarks;
    }

    public InfrastructureDamageData.InfraType getInfraType() {
        return infraType;
    }

    public int getDamaged() {
        return damaged;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public String getRemarks() {
        return remarks;
    }
}

package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;

public class InfrastructureDamageDataRow extends AgeGroupDataRow {
    private AgeGroupDataRow.InfraType infraType;
    private int damaged;
    private boolean isFunctional;
    private String remarks;

    public InfrastructureDamageDataRow(AgeGroupDataRow.InfraType infraType, int damaged, boolean isFunctional, String remarks) {
        super(infraType);
        this.infraType = infraType;
        this.damaged = damaged;
        this.isFunctional = isFunctional;
        this.remarks = remarks;
    }

    public AgeGroupDataRow.InfraType getInfraType() {
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

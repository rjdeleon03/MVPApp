package com.rjdeleon.mvp_app.Models.GeneralInformation;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public class InfrastructureDamageDataRow extends GenericEnumDataRow {
    private GenericEnumDataRow.InfraType infraType;
    private int damaged;
    private boolean isFunctional;
    private String remarks;

    public InfrastructureDamageDataRow(GenericEnumDataRow.InfraType infraType, int damaged, boolean isFunctional, String remarks) {
        super(infraType);
        this.infraType = infraType;
        this.damaged = damaged;
        this.isFunctional = isFunctional;
        this.remarks = remarks;
    }

    public InfrastructureDamageDataRow(GenericEnumDataRow.InfraType infraType) {
        super(infraType);
        this.infraType = infraType;
        this.damaged = 0;
        this.isFunctional = false;
        this.remarks = "";
    }

    public GenericEnumDataRow.InfraType getInfraType() {
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

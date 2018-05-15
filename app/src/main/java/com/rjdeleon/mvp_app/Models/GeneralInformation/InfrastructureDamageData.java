package com.rjdeleon.mvp_app.Models.GeneralInformation;

import java.util.ArrayList;
import java.util.List;

public class InfrastructureDamageData {

    private List<InfrastructureDamageDataRow> infrastructureDamageDataRows;

    public InfrastructureDamageData(List<InfrastructureDamageDataRow> infrastructureDamageDataRows) {
        this.infrastructureDamageDataRows = infrastructureDamageDataRows;
    }

    public InfrastructureDamageData() {
        this.infrastructureDamageDataRows = new ArrayList<>();
    }

    public List<InfrastructureDamageDataRow> getInfrastructureDamageDataRows() {
        return infrastructureDamageDataRows;
    }

    public void setInfrastructureDamageDataRows(List<InfrastructureDamageDataRow> infrastructureDamageDataRows) {
        this.infrastructureDamageDataRows = infrastructureDamageDataRows;
    }
}

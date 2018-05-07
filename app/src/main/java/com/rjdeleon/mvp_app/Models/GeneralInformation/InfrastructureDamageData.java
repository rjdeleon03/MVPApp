package com.rjdeleon.mvp_app.Models.GeneralInformation;

import java.util.ArrayList;
import java.util.List;

public class InfrastructureDamageData {
    public enum InfraType {
        SCHOOL,
        CHURCH,
        COVERED_COURT,
        BRGY_HALL,
        BRGY_HEALTH_STATION,
        EVACUATION_CENTER,
        BRIDGES,
        ROADS,
        MARKET,
        ELECTRICITY,
        WATER,
        HOSPITAL,
        SEAPORT_AIRPORT,
        COMMUNICATION_LINES,
        LIVELIHOOD_FACILITIES,
        OTHERS
    }

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
}

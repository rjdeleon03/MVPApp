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
        OTHERS;

        public static List<InfraType> asList() {
            List<InfraType> ageGroupList = new ArrayList<>();
            ageGroupList.add(SCHOOL);
            ageGroupList.add(CHURCH);
            ageGroupList.add(COVERED_COURT);
            ageGroupList.add(BRGY_HALL);
            ageGroupList.add(BRGY_HEALTH_STATION);
            ageGroupList.add(EVACUATION_CENTER);
            ageGroupList.add(BRIDGES);
            ageGroupList.add(ROADS);
            ageGroupList.add(MARKET);
            ageGroupList.add(ELECTRICITY);
            ageGroupList.add(WATER);
            ageGroupList.add(HOSPITAL);
            ageGroupList.add(SEAPORT_AIRPORT);
            ageGroupList.add(COMMUNICATION_LINES);
            ageGroupList.add(LIVELIHOOD_FACILITIES);
            ageGroupList.add(OTHERS);
            return ageGroupList;
        }

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

    public void setInfrastructureDamageDataRows(List<InfrastructureDamageDataRow> infrastructureDamageDataRows) {
        this.infrastructureDamageDataRows = infrastructureDamageDataRows;
    }
}

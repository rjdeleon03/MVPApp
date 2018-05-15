package com.rjdeleon.mvp_app.Models.Generics;

import org.apache.commons.text.WordUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AgeGroupDataRow {

    public enum AgeGroup implements GenericEnum {
        AGE_0_5,
        AGE_6_9,
        AGE_10_12,
        AGE_13_17,
        AGE_18_59,
        AGE_60_PLUS,
        ALL;

        @Override
        public String toString() {
            String str = "Ages ";
            switch(this) {
                case AGE_0_5:
                    return str + "0-5";
                case AGE_6_9:
                    return str + "6-9";
                case AGE_10_12:
                    return str + "10-12";
                case AGE_13_17:
                    return str + "13-17";
                case AGE_18_59:
                    return str + "18-59";
                case AGE_60_PLUS:
                    return str + "60+";
            }
            return null;
        }

        public static List<AgeGroup> asList() {
            List<AgeGroup> ageGroupList = new ArrayList<>();
            ageGroupList.add(AGE_0_5);
            ageGroupList.add(AGE_6_9);
            ageGroupList.add(AGE_10_12);
            ageGroupList.add(AGE_13_17);
            ageGroupList.add(AGE_18_59);
            ageGroupList.add(AGE_60_PLUS);
            return ageGroupList;
        }

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }
    }

    public enum InfraType implements GenericEnum {
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

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }

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

        @Override
        public Object getValue() {
            return this;
        }

        @Override
        public int getOrdinal() {
            return this.ordinal();
        }
    }

    private GenericEnum ageGroup;

    public AgeGroupDataRow(GenericEnum ageGroup) {
        this.ageGroup = ageGroup;
    }

    public GenericEnum getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(GenericEnum ageGroup) {
        this.ageGroup = ageGroup;
    }
}

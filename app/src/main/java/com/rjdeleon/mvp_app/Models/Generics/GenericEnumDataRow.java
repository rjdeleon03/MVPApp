package com.rjdeleon.mvp_app.Models.Generics;

import org.apache.commons.text.WordUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericEnumDataRow {

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
            List<AgeGroup> list = new ArrayList<>();
            list.add(AGE_0_5);
            list.add(AGE_6_9);
            list.add(AGE_10_12);
            list.add(AGE_13_17);
            list.add(AGE_18_59);
            list.add(AGE_60_PLUS);
            return list;
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
            List<InfraType> list = new ArrayList<>();
            list.add(SCHOOL);
            list.add(CHURCH);
            list.add(COVERED_COURT);
            list.add(BRGY_HALL);
            list.add(BRGY_HEALTH_STATION);
            list.add(EVACUATION_CENTER);
            list.add(BRIDGES);
            list.add(ROADS);
            list.add(MARKET);
            list.add(ELECTRICITY);
            list.add(WATER);
            list.add(HOSPITAL);
            list.add(SEAPORT_AIRPORT);
            list.add(COMMUNICATION_LINES);
            list.add(LIVELIHOOD_FACILITIES);
            list.add(OTHERS);
            return list;
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

    public enum HouseType implements GenericEnum {
        CONCRETE,
        SEMI_CONCRETE,
        LIGHT_MATERIALS,
        ALL;

        @Override
        public String toString() {
            return WordUtils.capitalizeFully(super.toString().replaceAll("_", " "));
        }

        public static List<HouseType> asList() {
            List<HouseType> list = new ArrayList<>();
            list.add(CONCRETE);
            list.add(SEMI_CONCRETE);
            list.add(LIGHT_MATERIALS);
            return list;
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

    public GenericEnumDataRow(GenericEnum ageGroup) {
        this.ageGroup = ageGroup;
    }

    public GenericEnum getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(GenericEnum ageGroup) {
        this.ageGroup = ageGroup;
    }
}

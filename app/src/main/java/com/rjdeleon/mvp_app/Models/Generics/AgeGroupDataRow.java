package com.rjdeleon.mvp_app.Models.Generics;

import java.util.ArrayList;
import java.util.List;

public abstract class AgeGroupDataRow {

    public enum AgeGroup {
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
    }

    private AgeGroup ageGroup;

    public AgeGroupDataRow(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }
}

package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;

public class EvacuationSiteData {

    public enum EvacuationType {
        PLANNED_EVACUATION_CENTER,
        LIVING_WITH_HOST_FAMILY,
        RENTING_AN_APARTMENT,
        LIVING_IN_DAMAGED_HOUSE,
        INFORMAL_SELF_SETTLED_CAMP,
        EMERGENCY_SHELTER,
        SQUATTING,
        OTHERS;

        @Override
        public String toString() {
            switch(this) {
                case PLANNED_EVACUATION_CENTER:
                    return "Planned Evacuation Center";
                case LIVING_WITH_HOST_FAMILY:
                    return "Living with Host Family";
                case RENTING_AN_APARTMENT:
                    return "Renting an Apartment";
                case LIVING_IN_DAMAGED_HOUSE:
                    return "Living in a Damaged House";
                case INFORMAL_SELF_SETTLED_CAMP:
                    return "Informal Self-Settled Camp";
                case EMERGENCY_SHELTER:
                    return "Emergency Shelter on Their Own Property";
                case SQUATTING:
                    return "Squatting";
                default:
                    return "Others";
            }
        }
    }

    public enum PlannedEvacuationType {
        EVACUATION_CENTER,
        MULTI_PURPOSE_HALL,
        CHURCH,
        SCHOOL,
        GYM,
        OTHERS;

        @Override
        public String toString() {
            switch (this) {
                case EVACUATION_CENTER:
                    return "Evacuation Center";
                case MULTI_PURPOSE_HALL:
                    return "Multi-Purpose Hall";
                case CHURCH:
                    return "Church";
                case SCHOOL:
                    return "School";
                case GYM:
                    return "Gym";
                default:
                    return "Others";
            }
        }
    }

    private String name;
    private String location;
    private boolean isDisplaced;
    private EvacuationType evacuationType;
    private PlannedEvacuationType plannedEvacuationType;
    private boolean isLguDesignated;
    private float communityDistance;
    private SimpleDate evacuationDate;
    private float shelterSize;
    private int familiesCount;

    public EvacuationSiteData(String name, String location, boolean isDisplaced, EvacuationType evacuationType, PlannedEvacuationType plannedEvacuationType, boolean isLguDesignated, float communityDistance, SimpleDate evacuationDate, float shelterSize, int familiesCount) {
        this.name = name;
        this.location = location;
        this.isDisplaced = isDisplaced;
        this.evacuationType = evacuationType;
        this.plannedEvacuationType = plannedEvacuationType;
        this.isLguDesignated = isLguDesignated;
        this.communityDistance = communityDistance;
        this.evacuationDate = evacuationDate;
        this.shelterSize = shelterSize;
        this.familiesCount = familiesCount;
    }

    public EvacuationSiteData() {
        this("", "", false, EvacuationType.PLANNED_EVACUATION_CENTER, PlannedEvacuationType.EVACUATION_CENTER, false, 0f, new SimpleDate(), 0f, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isDisplaced() {
        return isDisplaced;
    }

    public void setDisplaced(boolean displaced) {
        isDisplaced = displaced;
    }

    public EvacuationType getEvacuationType() {
        return evacuationType;
    }

    public void setEvacuationType(EvacuationType evacuationType) {
        this.evacuationType = evacuationType;
    }

    public PlannedEvacuationType getPlannedEvacuationType() {
        return plannedEvacuationType;
    }

    public void setPlannedEvacuationType(PlannedEvacuationType plannedEvacuationType) {
        this.plannedEvacuationType = plannedEvacuationType;
    }

    public boolean isLguDesignated() {
        return isLguDesignated;
    }

    public void setLguDesignated(boolean lguDesignated) {
        isLguDesignated = lguDesignated;
    }

    public float getCommunityDistance() {
        return communityDistance;
    }

    public void setCommunityDistance(float communityDistance) {
        this.communityDistance = communityDistance;
    }

    public SimpleDate getEvacuationDate() {
        return evacuationDate;
    }

    public void setEvacuationDate(SimpleDate evacuationDate) {
        this.evacuationDate = evacuationDate;
    }

    public float getShelterSize() {
        return shelterSize;
    }

    public void setShelterSize(float shelterSize) {
        this.shelterSize = shelterSize;
    }

    public int getFamiliesCount() {
        return familiesCount;
    }

    public void setFamiliesCount(int familiesCount) {
        this.familiesCount = familiesCount;
    }
}

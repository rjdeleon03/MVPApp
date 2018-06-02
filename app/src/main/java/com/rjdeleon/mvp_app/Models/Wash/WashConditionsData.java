package com.rjdeleon.mvp_app.Models.Wash;

public class WashConditionsData {

    private WaterLevelRemarksTuple drinkingLevel;
    private WaterLevelRemarksTuple bathingLevel;

    private int waterPointsNumber;

    private String waterPotable;
    private String timeFetchingWater;
    private String waterSourceOwner;
    private String payForWater;
    private String payForTranspo;
    private String timesNoWater;

    private boolean hasWashingFacilities;
    private boolean hasGarbageDisposal;
    private boolean isWasteSegregated;

    private String womenMenstruation;
    private String napkinsDisposed;
    private String diapersDispoed;
    private String defecationPractices;
    private String toiletFacilities;
    private String toiletConditions;

    private boolean isDefecationThreat;
    private boolean areFacilitiesMaintained;
    private boolean hasSecurityIssues;
    private boolean areToiletsSegregated;
    private boolean areToiletsAccessible;

    public WashConditionsData(WaterLevelRemarksTuple drinkingLevel,
                              WaterLevelRemarksTuple bathingLevel,
                              int waterPointsNumber,
                              String waterPotable,
                              String timeFetchingWater,
                              String waterSourceOwner,
                              String payForWater,
                              String payForTranspo,
                              String timesNoWater,
                              boolean hasWashingFacilities,
                              boolean hasGarbageDisposal,
                              boolean isWasteSegregated,
                              String womenMenstruation,
                              String napkinsDisposed,
                              String diapersDispoed,
                              String defecationPractices,
                              String toiletFacilities,
                              String toiletConditions,
                              boolean isDefecationThreat,
                              boolean areFacilitiesMaintained,
                              boolean hasSecurityIssues,
                              boolean areToiletsSegregated,
                              boolean areToiletsAccessible) {

        this.drinkingLevel = drinkingLevel;
        this.bathingLevel = bathingLevel;
        this.waterPointsNumber = waterPointsNumber;
        this.waterPotable = waterPotable;
        this.timeFetchingWater = timeFetchingWater;
        this.waterSourceOwner = waterSourceOwner;
        this.payForWater = payForWater;
        this.payForTranspo = payForTranspo;
        this.timesNoWater = timesNoWater;
        this.hasWashingFacilities = hasWashingFacilities;
        this.hasGarbageDisposal = hasGarbageDisposal;
        this.isWasteSegregated = isWasteSegregated;
        this.womenMenstruation = womenMenstruation;
        this.napkinsDisposed = napkinsDisposed;
        this.diapersDispoed = diapersDispoed;
        this.defecationPractices = defecationPractices;
        this.toiletFacilities = toiletFacilities;
        this.toiletConditions = toiletConditions;
        this.isDefecationThreat = isDefecationThreat;
        this.areFacilitiesMaintained = areFacilitiesMaintained;
        this.hasSecurityIssues = hasSecurityIssues;
        this.areToiletsSegregated = areToiletsSegregated;
        this.areToiletsAccessible = areToiletsAccessible;
    }

    public WashConditionsData() {
        this(new WaterLevelRemarksTuple(), new WaterLevelRemarksTuple(), 0, "", "", "", "", "", "", false, false, false, "", "", "", "", "", "", false, false, false, false, false);
    }

    public WaterLevelRemarksTuple getDrinkingLevel() {
        return drinkingLevel;
    }

    public void setDrinkingLevel(WaterLevelRemarksTuple drinkingLevel) {
        this.drinkingLevel = drinkingLevel;
    }

    public WaterLevelRemarksTuple getBathingLevel() {
        return bathingLevel;
    }

    public void setBathingLevel(WaterLevelRemarksTuple bathingLevel) {
        this.bathingLevel = bathingLevel;
    }

    public int getWaterPointsNumber() {
        return waterPointsNumber;
    }

    public void setWaterPointsNumber(int waterPointsNumber) {
        this.waterPointsNumber = waterPointsNumber;
    }

    public String getWaterPotable() {
        return waterPotable;
    }

    public void setWaterPotable(String waterPotable) {
        this.waterPotable = waterPotable;
    }

    public String getTimeFetchingWater() {
        return timeFetchingWater;
    }

    public void setTimeFetchingWater(String timeFetchingWater) {
        this.timeFetchingWater = timeFetchingWater;
    }

    public String getWaterSourceOwner() {
        return waterSourceOwner;
    }

    public void setWaterSourceOwner(String waterSourceOwner) {
        this.waterSourceOwner = waterSourceOwner;
    }

    public String getPayForWater() {
        return payForWater;
    }

    public void setPayForWater(String payForWater) {
        this.payForWater = payForWater;
    }

    public String getPayForTranspo() {
        return payForTranspo;
    }

    public void setPayForTranspo(String payForTranspo) {
        this.payForTranspo = payForTranspo;
    }

    public String getTimesNoWater() {
        return timesNoWater;
    }

    public void setTimesNoWater(String timesNoWater) {
        this.timesNoWater = timesNoWater;
    }

    public boolean getHasWashingFacilities() {
        return hasWashingFacilities;
    }

    public void setHasWashingFacilities(boolean hasWashingFacilities) {
        this.hasWashingFacilities = hasWashingFacilities;
    }

    public boolean getHasGarbageDisposal() {
        return hasGarbageDisposal;
    }

    public void setHasGarbageDisposal(boolean hasGarbageDisposal) {
        this.hasGarbageDisposal = hasGarbageDisposal;
    }

    public boolean getWasteSegregated() {
        return isWasteSegregated;
    }

    public void setWasteSegregated(boolean wasteSegregated) {
        isWasteSegregated = wasteSegregated;
    }

    public String getWomenMenstruation() {
        return womenMenstruation;
    }

    public void setWomenMenstruation(String womenMenstruation) {
        this.womenMenstruation = womenMenstruation;
    }

    public String getNapkinsDisposed() {
        return napkinsDisposed;
    }

    public void setNapkinsDisposed(String napkinsDisposed) {
        this.napkinsDisposed = napkinsDisposed;
    }

    public String getDiapersDispoed() {
        return diapersDispoed;
    }

    public void setDiapersDispoed(String diapersDispoed) {
        this.diapersDispoed = diapersDispoed;
    }

    public String getDefecationPractices() {
        return defecationPractices;
    }

    public void setDefecationPractices(String defecationPractices) {
        this.defecationPractices = defecationPractices;
    }

    public String getToiletFacilities() {
        return toiletFacilities;
    }

    public void setToiletFacilities(String toiletFacilities) {
        this.toiletFacilities = toiletFacilities;
    }

    public String getToiletConditions() {
        return toiletConditions;
    }

    public void setToiletConditions(String toiletConditions) {
        this.toiletConditions = toiletConditions;
    }

    public boolean getDefecationThreat() {
        return isDefecationThreat;
    }

    public void setDefecationThreat(boolean defecationThreat) {
        isDefecationThreat = defecationThreat;
    }

    public boolean getAreFacilitiesMaintained() {
        return areFacilitiesMaintained;
    }

    public void setAreFacilitiesMaintained(boolean areFacilitiesMaintained) {
        this.areFacilitiesMaintained = areFacilitiesMaintained;
    }

    public boolean getHasSecurityIssues() {
        return hasSecurityIssues;
    }

    public void setHasSecurityIssues(boolean hasSecurityIssues) {
        this.hasSecurityIssues = hasSecurityIssues;
    }

    public boolean getAreToiletsSegregated() {
        return areToiletsSegregated;
    }

    public void setAreToiletsSegregated(boolean areToiletsSegregated) {
        this.areToiletsSegregated = areToiletsSegregated;
    }

    public boolean getAreToiletsAccessible() {
        return areToiletsAccessible;
    }

    public void setAreToiletsAccessible(boolean areToiletsAccessible) {
        this.areToiletsAccessible = areToiletsAccessible;
    }
}

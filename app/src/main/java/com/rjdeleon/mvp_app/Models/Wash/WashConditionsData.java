package com.rjdeleon.mvp_app.Models.Wash;

public class WashConditionsData {

    private WaterLevelRemarksTuple drinkingLevel;
    private WaterLevelRemarksTuple bathingLevel;

    private String waterPointsNumber;
    private String waterPotable;
    private String timeFetchingWater;
    private String waterSourceOwner;
    private String payForWater;
    private String payForTranspo;
    private String timesNoWater;
    private String hasWashingFacilities;
    private String hasGarbageDisposal;
    private String isWasteSegregated;
    private String womenMenstruation;
    private String napkinsDisposed;
    private String diapersDispoed;
    private String defecationPractices;
    private String toiletFacilities;
    private String toiletConditions;
    private String isDefecationThreat;
    private String areFacilitiesMaintained;
    private String hasSecurityIssues;
    private String areToiletsSegregated;
    private String areToiletsAccessible;

    public WashConditionsData(WaterLevelRemarksTuple drinkingLevel,
                              WaterLevelRemarksTuple bathingLevel,
                              String waterPointsNumber,
                              String waterPotable,
                              String timeFetchingWater,
                              String waterSourceOwner,
                              String payForWater,
                              String payForTranspo,
                              String timesNoWater,
                              String hasWashingFacilities,
                              String hasGarbageDisposal,
                              String isWasteSegregated,
                              String womenMenstruation,
                              String napkinsDisposed,
                              String diapersDispoed,
                              String defecationPractices,
                              String toiletFacilities,
                              String toiletConditions,
                              String isDefecationThreat,
                              String areFacilitiesMaintained,
                              String hasSecurityIssues,
                              String areToiletsSegregated,
                              String areToiletsAccessible) {

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
        this(new WaterLevelRemarksTuple(), new WaterLevelRemarksTuple(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
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

    public String getWaterPointsNumber() {
        return waterPointsNumber;
    }

    public void setWaterPointsNumber(String waterPointsNumber) {
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

    public String getHasWashingFacilities() {
        return hasWashingFacilities;
    }

    public void setHasWashingFacilities(String hasWashingFacilities) {
        this.hasWashingFacilities = hasWashingFacilities;
    }

    public String getHasGarbageDisposal() {
        return hasGarbageDisposal;
    }

    public void setHasGarbageDisposal(String hasGarbageDisposal) {
        this.hasGarbageDisposal = hasGarbageDisposal;
    }

    public String getIsWasteSegregated() {
        return isWasteSegregated;
    }

    public void setIsWasteSegregated(String isWasteSegregated) {
        this.isWasteSegregated = isWasteSegregated;
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

    public String getIsDefecationThreat() {
        return isDefecationThreat;
    }

    public void setIsDefecationThreat(String isDefecationThreat) {
        this.isDefecationThreat = isDefecationThreat;
    }

    public String getAreFacilitiesMaintained() {
        return areFacilitiesMaintained;
    }

    public void setAreFacilitiesMaintained(String areFacilitiesMaintained) {
        this.areFacilitiesMaintained = areFacilitiesMaintained;
    }

    public String getHasSecurityIssues() {
        return hasSecurityIssues;
    }

    public void setHasSecurityIssues(String hasSecurityIssues) {
        this.hasSecurityIssues = hasSecurityIssues;
    }

    public String getAreToiletsSegregated() {
        return areToiletsSegregated;
    }

    public void setAreToiletsSegregated(String areToiletsSegregated) {
        this.areToiletsSegregated = areToiletsSegregated;
    }

    public String getAreToiletsAccessible() {
        return areToiletsAccessible;
    }

    public void setAreToiletsAccessible(String areToiletsAccessible) {
        this.areToiletsAccessible = areToiletsAccessible;
    }
}
package com.cpu.quikdata.Models.Wash;

public class WashGapsData {

    private String isAssistanceEnough;
    private String isAssistanceRelevant;
    private String isWaterSourceAccessible;
    private String didConsultBeforeDistribution;
    private String hasWasteMgmtOrientation;
    private String attitudeTowardsGenders;
    private String hasSupportMechanisms;
    private String womenParticipation;

    public WashGapsData(String isAssistanceEnough, String isAssistanceRelevant, String isWaterSourceAccessible, String didConsultBeforeDistribution, String hasWasteMgmtOrientation, String attitudeTowardsGenders, String hasSupportMechanisms, String womenParticipation) {
        this.isAssistanceEnough = isAssistanceEnough;
        this.isAssistanceRelevant = isAssistanceRelevant;
        this.isWaterSourceAccessible = isWaterSourceAccessible;
        this.didConsultBeforeDistribution = didConsultBeforeDistribution;
        this.hasWasteMgmtOrientation = hasWasteMgmtOrientation;
        this.attitudeTowardsGenders = attitudeTowardsGenders;
        this.hasSupportMechanisms = hasSupportMechanisms;
        this.womenParticipation = womenParticipation;
    }

    public WashGapsData() {
        this("", "", "", "", "", "", "", "");
    }

    public String getIsAssistanceEnough() {
        return isAssistanceEnough;
    }

    public void setIsAssistanceEnough(String isAssistanceEnough) {
        this.isAssistanceEnough = isAssistanceEnough;
    }

    public String getIsAssistanceRelevant() {
        return isAssistanceRelevant;
    }

    public void setIsAssistanceRelevant(String isAssistanceRelevant) {
        this.isAssistanceRelevant = isAssistanceRelevant;
    }

    public String getIsWaterSourceAccessible() {
        return isWaterSourceAccessible;
    }

    public void setIsWaterSourceAccessible(String isWaterSourceAccessible) {
        this.isWaterSourceAccessible = isWaterSourceAccessible;
    }

    public String getDidConsultBeforeDistribution() {
        return didConsultBeforeDistribution;
    }

    public void setDidConsultBeforeDistribution(String didConsultBeforeDistribution) {
        this.didConsultBeforeDistribution = didConsultBeforeDistribution;
    }

    public String getHasWasteMgmtOrientation() {
        return hasWasteMgmtOrientation;
    }

    public void setHasWasteMgmtOrientation(String hasWasteMgmtOrientation) {
        this.hasWasteMgmtOrientation = hasWasteMgmtOrientation;
    }

    public String getAttitudeTowardsGenders() {
        return attitudeTowardsGenders;
    }

    public void setAttitudeTowardsGenders(String attitudeTowardsGenders) {
        this.attitudeTowardsGenders = attitudeTowardsGenders;
    }

    public String getHasSupportMechanisms() {
        return hasSupportMechanisms;
    }

    public void setHasSupportMechanisms(String hasSupportMechanisms) {
        this.hasSupportMechanisms = hasSupportMechanisms;
    }

    public String getWomenParticipation() {
        return womenParticipation;
    }

    public void setWomenParticipation(String womenParticipation) {
        this.womenParticipation = womenParticipation;
    }
}

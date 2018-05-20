package com.rjdeleon.mvp_app.Models.ShelterInfo;

public class ShelterGapsData {

    private String hasSeparateCubicles;
    private String isAssistanceCulturallyAppropriate;
    private String isShelterAppropriate;
    private String hasAccessToBasicServices;
    private String hasAbleBodiedMember;
    private String hasReferralPathwayForGbv;
    private String hasGbvProtectionFocalPoint;

    public ShelterGapsData(String hasSeparateCubicles, String isAssistanceCulturallyAppropriate, String isShelterAppropriate, String hasAccessToBasicServices, String hasAbleBodiedMember, String hasReferralPathwayForGbv, String hasGbvProtectionFocalPoint) {
        this.hasSeparateCubicles = hasSeparateCubicles;
        this.isAssistanceCulturallyAppropriate = isAssistanceCulturallyAppropriate;
        this.isShelterAppropriate = isShelterAppropriate;
        this.hasAccessToBasicServices = hasAccessToBasicServices;
        this.hasAbleBodiedMember = hasAbleBodiedMember;
        this.hasReferralPathwayForGbv = hasReferralPathwayForGbv;
        this.hasGbvProtectionFocalPoint = hasGbvProtectionFocalPoint;
    }

    public ShelterGapsData() {
        this.hasSeparateCubicles = "";
        this.isAssistanceCulturallyAppropriate = "";
        this.isShelterAppropriate = "";
        this.hasAccessToBasicServices = "";
        this.hasAbleBodiedMember = "";
        this.hasReferralPathwayForGbv = "";
        this.hasGbvProtectionFocalPoint = "";
    }

    public String getHasSeparateCubicles() {
        return hasSeparateCubicles;
    }

    public void setHasSeparateCubicles(String hasSeparateCubicles) {
        this.hasSeparateCubicles = hasSeparateCubicles;
    }

    public String getIsAssistanceCulturallyAppropriate() {
        return isAssistanceCulturallyAppropriate;
    }

    public void setIsAssistanceCulturallyAppropriate(String isAssistanceCulturallyAppropriate) {
        this.isAssistanceCulturallyAppropriate = isAssistanceCulturallyAppropriate;
    }

    public String getIsShelterAppropriate() {
        return isShelterAppropriate;
    }

    public void setIsShelterAppropriate(String isShelterAppropriate) {
        this.isShelterAppropriate = isShelterAppropriate;
    }

    public String getHasAccessToBasicServices() {
        return hasAccessToBasicServices;
    }

    public void setHasAccessToBasicServices(String hasAccessToBasicServices) {
        this.hasAccessToBasicServices = hasAccessToBasicServices;
    }

    public String getHasAbleBodiedMember() {
        return hasAbleBodiedMember;
    }

    public void setHasAbleBodiedMember(String hasAbleBodiedMember) {
        this.hasAbleBodiedMember = hasAbleBodiedMember;
    }

    public String getHasReferralPathwayForGbv() {
        return hasReferralPathwayForGbv;
    }

    public void setHasReferralPathwayForGbv(String hasReferralPathwayForGbv) {
        this.hasReferralPathwayForGbv = hasReferralPathwayForGbv;
    }

    public String getHasGbvProtectionFocalPoint() {
        return hasGbvProtectionFocalPoint;
    }

    public void setHasGbvProtectionFocalPoint(String hasGbvProtectionFocalPoint) {
        this.hasGbvProtectionFocalPoint = hasGbvProtectionFocalPoint;
    }
}

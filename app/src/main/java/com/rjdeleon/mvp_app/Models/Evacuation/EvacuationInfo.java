package com.rjdeleon.mvp_app.Models.Evacuation;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;

public class EvacuationInfo implements NormalizableData {

    private EvacuationSiteData siteData;
    private EvacuationPopulationData populationData;
    private EvacuationFacilitiesData facilitiesData;
    private EvacuationWashData washData;
    private EvacuationSecurityData securityData;
    private GenericCopingData copingData;

    public EvacuationInfo(EvacuationSiteData siteData, EvacuationPopulationData populationData, EvacuationFacilitiesData facilitiesData, EvacuationWashData washData, EvacuationSecurityData securityData, GenericCopingData copingData) {
        this.siteData = siteData;
        this.populationData = populationData;
        this.facilitiesData = facilitiesData;
        this.washData = washData;
        this.securityData = securityData;
        this.copingData = copingData;
    }

    public EvacuationInfo() {
        this(new EvacuationSiteData(), new EvacuationPopulationData(), new EvacuationFacilitiesData(), new EvacuationWashData(), new EvacuationSecurityData(), new GenericCopingData());
    }

    public EvacuationSiteData getSiteData() {
        return siteData;
    }

    public void setSiteData(EvacuationSiteData siteData) {
        this.siteData = siteData;
    }

    public EvacuationPopulationData getPopulationData() {
        return populationData;
    }

    public void setPopulationData(EvacuationPopulationData populationData) {
        this.populationData = populationData;
    }

    public EvacuationFacilitiesData getFacilitiesData() {
        return facilitiesData;
    }

    public void setFacilitiesData(EvacuationFacilitiesData facilitiesData) {
        this.facilitiesData = facilitiesData;
    }

    public EvacuationWashData getWashData() {
        return washData;
    }

    public void setWashData(EvacuationWashData washData) {
        this.washData = washData;
    }

    public EvacuationSecurityData getSecurityData() {
        return securityData;
    }

    public void setSecurityData(EvacuationSecurityData securityData) {
        this.securityData = securityData;
    }

    public GenericCopingData getCopingData() {
        return copingData;
    }

    public void setCopingData(GenericCopingData copingData) {
        this.copingData = copingData;
    }

    @Override
    public void normalize() {
        if (populationData != null) populationData.normalize();
    }
}

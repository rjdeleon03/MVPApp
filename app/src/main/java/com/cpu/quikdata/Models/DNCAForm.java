package com.cpu.quikdata.Models;

import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;
import com.cpu.quikdata.Models.Evacuation.EvacuationList;
import com.cpu.quikdata.Models.FoodSecurity.FoodSecurity;
import com.cpu.quikdata.Models.FormDetails.FormDetails;
import com.cpu.quikdata.Models.GeneralInformation.GenInfo;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Models.Health.HealthInfo;
import com.cpu.quikdata.Models.Livelihoods.Livelihoods;
import com.cpu.quikdata.Models.Shelter.ShelterInfo;
import com.cpu.quikdata.Models.Wash.WashInfo;

import java.util.ArrayList;
import java.util.List;

public class DNCAForm implements NormalizableData {

    private FormDetails formDetails;
    private GenInfo genInfo;
    private ShelterInfo shelterInfo;
    private FoodSecurity foodSecurity;
    private Livelihoods livelihoods;
    private HealthInfo healthInfo;
    private WashInfo washInfo;
    private EvacuationList evacuationList;
    private CaseStories caseStories;

    public DNCAForm(FormDetails formDetails,
                    GenInfo genInfo,
                    ShelterInfo shelterInfo,
                    FoodSecurity foodSecurity,
                    Livelihoods livelihoods,
                    HealthInfo healthInfo,
                    WashInfo washInfo,
                    EvacuationList evacuationList,
                    CaseStories caseStories) {

        this.formDetails = formDetails;
        this.genInfo = genInfo;
        this.shelterInfo = shelterInfo;
        this.foodSecurity = foodSecurity;
        this.livelihoods = livelihoods;
        this.healthInfo = healthInfo;
        this.washInfo = washInfo;
        this.evacuationList = evacuationList;
        this.caseStories = caseStories;
    }

    public DNCAForm() {
        this(new FormDetails(),
                new GenInfo(),
                new ShelterInfo(),
                new FoodSecurity(),
                new Livelihoods(),
                new HealthInfo(),
                new WashInfo(),
                new EvacuationList(),
                new CaseStories());
    }

    public FormDetails getFormDetails() {
        return formDetails;
    }

    public void setFormDetails(FormDetails formDetails) {
        this.formDetails = formDetails;
    }

    public GenInfo getGenInfo() {
        return genInfo;
    }

    public void setGenInfo(GenInfo genInfo) {
        this.genInfo = genInfo;
    }

    public ShelterInfo getShelterInfo() {
        return shelterInfo;
    }

    public void setShelterInfo(ShelterInfo shelterInfo) {
        this.shelterInfo = shelterInfo;
    }

    public FoodSecurity getFoodSecurity() {
        return foodSecurity;
    }

    public void setFoodSecurity(FoodSecurity foodSecurity) {
        this.foodSecurity = foodSecurity;
    }

    public Livelihoods getLivelihoods() {
        return livelihoods;
    }

    public void setLivelihoods(Livelihoods livelihoods) {
        this.livelihoods = livelihoods;
    }

    public HealthInfo getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(HealthInfo healthInfo) {
        this.healthInfo = healthInfo;
    }

    public WashInfo getWashInfo() {
        return washInfo;
    }

    public void setWashInfo(WashInfo washInfo) {
        this.washInfo = washInfo;
    }

    public EvacuationList getEvacuationList() {
        return evacuationList;
    }

    public void setEvacuationList(EvacuationList evacuationList) {
        this.evacuationList = evacuationList;
    }

    public CaseStories getCaseStories() {
        return caseStories;
    }

    public void setCaseStories(CaseStories caseStories) {
        this.caseStories = caseStories;
    }

    @Override
    public void normalize() {
        genInfo.normalize();
        shelterInfo.normalize();
    }
}

package com.cpu.quikdata.Models;

import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;
import com.cpu.quikdata.Models.FoodSecurity.FoodSecurity;
import com.cpu.quikdata.Models.GeneralInformation.GenInfo;
import com.cpu.quikdata.Models.Generics.NormalizableData;
import com.cpu.quikdata.Models.Health.HealthInfo;
import com.cpu.quikdata.Models.Livelihoods.Livelihoods;
import com.cpu.quikdata.Models.Shelter.ShelterInfo;
import com.cpu.quikdata.Models.Wash.WashInfo;

public class DNCAForm implements NormalizableData {

    private FormInfo formInfo;
    private GenInfo genInfo;
    private ShelterInfo shelterInfo;
    private FoodSecurity foodSecurity;
    private Livelihoods livelihoods;
    private HealthInfo healthInfo;
    private WashInfo washInfo;
    private EvacuationInfo evacuationInfo;

    public DNCAForm(FormInfo formInfo, GenInfo genInfo, ShelterInfo shelterInfo, FoodSecurity foodSecurity, Livelihoods livelihoods, HealthInfo healthInfo, WashInfo washInfo, EvacuationInfo evacuationInfo) {
        this.formInfo = formInfo;
        this.genInfo = genInfo;
        this.shelterInfo = shelterInfo;
        this.foodSecurity = foodSecurity;
        this.livelihoods = livelihoods;
        this.healthInfo = healthInfo;
        this.washInfo = washInfo;
        this.evacuationInfo = evacuationInfo;
    }

    public DNCAForm() {
        this(new FormInfo(), new GenInfo(), new ShelterInfo(), new FoodSecurity(), new Livelihoods(), new HealthInfo(), new WashInfo(), new EvacuationInfo());
    }

    public FormInfo getFormInfo() {
        return formInfo;
    }

    public void setFormInfo(FormInfo formInfo) {
        this.formInfo = formInfo;
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

    public EvacuationInfo getEvacuationInfo() {
        return evacuationInfo;
    }

    public void setEvacuationInfo(EvacuationInfo evacuationInfo) {
        this.evacuationInfo = evacuationInfo;
    }

    @Override
    public void normalize() {
        genInfo.normalize();
        shelterInfo.normalize();
    }
}
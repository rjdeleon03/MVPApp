package com.rjdeleon.mvp_app.Models;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodSecurity;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Models.Livelihoods.Livelihoods;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterInfo;

public class DNCAForm implements NormalizableData {

    private FormInfo formInfo;
    private GenInfo genInfo;
    private ShelterInfo shelterInfo;
    private FoodSecurity foodSecurity;
    private Livelihoods livelihoods;

    public DNCAForm(FormInfo formInfo, GenInfo genInfo, ShelterInfo shelterInfo, FoodSecurity foodSecurity, Livelihoods livelihoods) {
        this.formInfo = formInfo;
        this.genInfo = genInfo;
        this.shelterInfo = shelterInfo;
        this.foodSecurity = foodSecurity;
        this.livelihoods = livelihoods;
    }

    public DNCAForm() {
        this(new FormInfo(), new GenInfo(), new ShelterInfo(), new FoodSecurity(), new Livelihoods());
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

    @Override
    public void normalize() {
        genInfo.normalize();
        shelterInfo.normalize();
    }
}

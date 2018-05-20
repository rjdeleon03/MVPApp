package com.rjdeleon.mvp_app.Models;

import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.Generics.NormalizableData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterInfo;

public class DNCAForm implements NormalizableData {

    private FormInfo formInfo;
    private GenInfo genInfo;
    private ShelterInfo shelterInfo;

    public DNCAForm(FormInfo formInfo, GenInfo genInfo, ShelterInfo shelterInfo) {
        this.formInfo = formInfo;
        this.genInfo = genInfo;
        this.shelterInfo = shelterInfo;
    }

    public DNCAForm() {
        this.formInfo = new FormInfo();
        this.genInfo = new GenInfo();
        this.shelterInfo = new ShelterInfo();
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

    @Override
    public void normalize() {
        genInfo.normalize();
    }
}

package com.rjdeleon.mvp_app.Models;

import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;

public class DNCAForm {

    private FormInfo formInfo;
    private GenInfo genInfo;

    public DNCAForm(FormInfo formInfo, GenInfo genInfo) {
        this.formInfo = formInfo;
        this.genInfo = genInfo;
    }

    public DNCAForm() {
        this.formInfo = new FormInfo();
        this.genInfo = new GenInfo();
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
}

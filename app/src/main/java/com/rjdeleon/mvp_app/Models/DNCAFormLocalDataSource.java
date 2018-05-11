package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public class DNCAFormLocalDataSource implements DNCAFormDataSource {

    private static volatile DNCAFormLocalDataSource INSTANCE;

    private DNCAFormLocalDataSource() {

    }

    public static DNCAFormLocalDataSource getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DNCAFormLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback) {

    }

    @Override
    public void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback) {

    }

    @Override
    public void saveFormInfo(FormInfo formInfo) {

    }

    @Override
    public void saveGenInfo(GenInfo genInfo) {

    }
}

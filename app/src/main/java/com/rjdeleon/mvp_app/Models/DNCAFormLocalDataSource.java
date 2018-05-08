package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

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
    public void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback) {

    }

    @Override
    public void saveFormInfo(FormInfo formInfo) {

    }

    @Override
    public void saveGenInfoCalamityDetails(CalamityDesc calamityDesc) {

    }

    @Override
    public void saveGenInfoPopulationData(PopulationData populationData) {

    }
}

package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

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
}

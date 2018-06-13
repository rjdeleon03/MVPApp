package com.cpu.quikdata.Models;

import android.support.annotation.NonNull;

import com.cpu.quikdata.Models.GeneralInformation.CalamityDesc;
import com.cpu.quikdata.Models.GeneralInformation.GenInfo;
import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;

public class DNCAFormLocalDataSource implements DNCAFormDataSource {

    private static volatile DNCAFormLocalDataSource INSTANCE;

    private DNCAFormLocalDataSource() {

    }

    public static DNCAFormLocalDataSource newInstance() {
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
    public void submitDncaForm(@NonNull SubmitDncaFormCallback callback) {

    }

    @Override
    public void uploadImages(@NonNull UploadImagesCallback callback) {

    }

    @Override
    public void saveFormInfo(FormInfo formInfo) {

    }

    @Override
    public void saveGenInfo(GenInfo genInfo) {

    }
}

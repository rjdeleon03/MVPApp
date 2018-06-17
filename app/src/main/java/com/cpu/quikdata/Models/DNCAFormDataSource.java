package com.cpu.quikdata.Models;

import android.support.annotation.NonNull;

import com.cpu.quikdata.Models.GeneralInformation.CalamityDesc;
import com.cpu.quikdata.Models.GeneralInformation.GenInfo;
import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;

import java.util.List;

/**
 * Main entry point for accessing DNCA Form data
 */
public interface DNCAFormDataSource {

    interface LoadDncaFormsCallback {
        void onDncaFormsLoaded(List<DNCAListItem> forms);

        void onDataNotAvailable();
    }

    interface GetDncaFormCallback {
        void onDncaFormLoaded(DNCAForm form);

        void onDataNotAvailable();
    }

    interface SubmitDncaFormCallback {
        void onDncaFormSubmitted();
    }

    interface UploadImagesCallback {
        void onImagesUploaded(List<String> images);
    }

    void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback);

    void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback);

    void submitDncaForm(@NonNull SubmitDncaFormCallback callback);

    void uploadImages(@NonNull UploadImagesCallback callback);
}

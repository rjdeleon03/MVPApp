package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

import java.util.List;

/**
 * Main entry point for accessing DNCA Form data
 */
public interface DNCAFormDataSource {

    interface LoadDncaFormsCallback {
        void onDncaFormsLoaded(List<DNCAForm> forms);

        void onDataNotAvailable();
    }

    interface GetDncaFormCallback {
        void onDncaFormLoaded(DNCAForm form);

        void onDataNotAvailable();
    }

    void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback);

    void saveFormInfo(FormInfo formInfo);

    void saveGenInfoCalamityDetails(CalamityDesc calamityDesc);

    void saveGenInfoPopulationDataRow(PopulationDataRow populationDataRow);
}

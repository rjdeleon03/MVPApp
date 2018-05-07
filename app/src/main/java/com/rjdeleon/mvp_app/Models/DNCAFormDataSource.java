package com.rjdeleon.mvp_app.Models;

import android.support.annotation.NonNull;

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

    void createNewDncaForm(@NonNull GetDncaFormCallback callback);
}

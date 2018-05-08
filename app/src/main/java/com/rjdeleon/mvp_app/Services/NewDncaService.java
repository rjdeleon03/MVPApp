package com.rjdeleon.mvp_app.Services;

import android.support.annotation.NonNull;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.FormInfo;

public class NewDncaService implements DNCAFormDataSource.GetDncaFormCallback {

    private static NewDncaService INSTANCE = null;
    private DNCAFormRepository mDncaFormRepository;
    private DNCAForm mForm;

    /**
     * Private constructor
     * @param dncaFormRepository
     */
    private NewDncaService(@NonNull DNCAFormRepository dncaFormRepository) {
        mDncaFormRepository = dncaFormRepository;
    }

    /**
     * Gets instance and creates it if necessary
     * @param dncaFormRepository
     * @return
     */
    public static NewDncaService getInstance(@NonNull DNCAFormRepository dncaFormRepository) {
        return new NewDncaService(dncaFormRepository);
    }

    /**
     * Destroys instance so new instance will be created when getInstance() is called
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Requests new DNCA form from repository
     */
    public void createNewDncaForm() {
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Saves form details to the form
     * @param formInfo
     */
    public void saveFormDetails(FormInfo formInfo) {
        mForm.setFormInfo(formInfo);
    }

    /**
     * Callback when DNCA form has been retrieved
     * @param form
     */
    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        mForm = form;
    }

    /**
     * Callback when requested data from repository is not found
     */
    @Override
    public void onDataNotAvailable() {

    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class NewDncaViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback, DNCAFormDataSource.SubmitDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;

    /**
     * Constructor
     * @param context
     */
    public NewDncaViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Perform cleanup to avoid potential memory leaks
     */
    public void performCleanup() {

        // Clear references to avoid potential memory leaks
        mNewDncaNavigator = null;
    }

    /**
     * For the activity's use on navigating back
      */
    public void navigateOnBackButtonPressed() {

        // Perform clean up and navigate when back button is pressed
        mNewDncaNavigator.onBackButtonPressed();
    }

    /**
     * Handles navigation when submit button is pressed
     */
    public void navigateOnSubmitButtonPressed() {
        mDncaFormRepository.submitDncaForm(this);
    }

    /**
     * Handles navigation when form details button is pressed
     */
    public void navigateOnFormDetailsButtonPressed() {
        mNewDncaNavigator.onFormDetailsButtonPressed();
    }

    /**
     * Handles navigation when general information button is pressed
     */
    public void navigateOnGenInfoButtonPressed() {
        mNewDncaNavigator.onGenInfoButtonPressed();
    }

    /**
     * Callback for when form has been created
     * @param form
     */
    @Override
    public void onDncaFormLoaded(DNCAForm form) {

    }

    /**
     * Callback for when form has not been created due to failure or data is not available
     */
    @Override
    public void onDataNotAvailable() {

    }

    /**
     * Callback for when form has been submitted
     */
    @Override
    public void onDncaFormSubmitted() {
        navigateOnBackButtonPressed();
    }
}

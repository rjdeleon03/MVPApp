package com.cpu.quikdata.Modules.NewDnca;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class NewDncaViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback, DNCAFormDataSource.SubmitDncaFormCallback, DNCAFormDataSource.UploadImagesCallback {

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
        DNCAFormRepository.destroyInstance();
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
        mDncaFormRepository.uploadImages(this);
//        mDncaFormRepository.submitDncaForm(this);
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
     * Handles navigation when shelter information button is pressed
     */
    public void navigateOnShelterInfoButtonPressed() {
        mNewDncaNavigator.onShelterInfoButtonPressed();
    }

    /**
     * Handles navigation when food security button is pressed
     */
    public void navigateOnFoodSecurityButtonPressed() {
        mNewDncaNavigator.onFoodSecurityButtonPressed();
    }

    /**
     * Handles navigation when livelihoods button is pressed
     */
    public void navigateOnLivelihoodsButtonPressed() {
        mNewDncaNavigator.onLivelihoodsButtonPressed();
    }

    /**
     * Handles navigation when health button is pressed
     */
    public void navigateOnHealthButtonPressed() {
        mNewDncaNavigator.onHealthButtonPressed();
    }

    /**
     * Handles navigation when wash button is pressed
     */
    public void navigateOnWashButtonPressed() {
        mNewDncaNavigator.onWashButtonPressed();
    }

    /**
     * Handles navigation when evacuation button is pressed
     */
    public void navigateOnEvacuationButtonPressed() {
        mNewDncaNavigator.onEvacuationButtonPressed();
    }

    /**
     * Handles navigation when case stories button is pressed
     */
    public void navigateOnCaseStoriesButtonPressed() {
        mNewDncaNavigator.onCaseStoriesButtonPressed();
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

    /**
     * Callback for when images have been submitted
     */
    @Override
    public void onImagesUploaded() {

    }
}

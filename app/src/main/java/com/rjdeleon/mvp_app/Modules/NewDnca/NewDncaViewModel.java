package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class NewDncaViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    private DNCAFormRepository mDncaFormRepository;

    /**
     * Constructor
     * @param context
     */
    public NewDncaViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        mDncaFormRepository = dncaFormRepository;
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

        // Navigate when back button is pressed
        mNewDncaNavigator.onBackButtonPressed();
    }

    /**
     * Navigate to Form Details view
     */
    public void navigateOnFormDetailsButtonPressed() {
        mNewDncaNavigator.onFormDetailsButtonPressed();
    }

    /**
     * Navigate to General Information view
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
}

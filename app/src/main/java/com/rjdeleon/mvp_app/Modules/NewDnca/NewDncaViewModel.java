package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class NewDncaViewModel extends NewDncaBaseViewModel {

    public NewDncaViewModel(Context context) {
        super(context);
    }

    public void setNavigator(NewDncaNavigator navigator) {
        mNewDncaNavigator = navigator;
    }

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

}

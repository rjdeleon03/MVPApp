package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.content.Context;

public class NewDncaViewModel {

    private final Context mContext; // Application context

    private NewDncaNavigator mNewDncaNavigator;

    public NewDncaViewModel(Context context) {

        // Force use of application context
        mContext = context.getApplicationContext();
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
        mNewDncaNavigator.onFormDetailsButtonPressed();
    }

}

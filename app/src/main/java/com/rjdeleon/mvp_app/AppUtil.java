package com.rjdeleon.mvp_app;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

public class AppUtil {

    public static void hideSoftKeyboard(Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    public static PopulationData.AgeGroup stringToAgeGroup(String str) {
        if (str.endsWith("0-5")) {
            return PopulationData.AgeGroup.AGE_0_5;
        } else if (str.endsWith("6-9")) {
            return PopulationData.AgeGroup.AGE_6_9;
        } else if (str.endsWith("10-12")) {
            return PopulationData.AgeGroup.AGE_10_12;
        } else if (str.endsWith("13-17")) {
            return PopulationData.AgeGroup.AGE_13_17;
        } else if (str.endsWith("18-59")) {
            return PopulationData.AgeGroup.AGE_18_59;
        } else {
            return PopulationData.AgeGroup.AGE_60_PLUS;
        }
    }

}

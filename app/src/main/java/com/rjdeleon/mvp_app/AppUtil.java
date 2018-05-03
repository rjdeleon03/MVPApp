package com.rjdeleon.mvp_app;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.InverseBindingAdapter;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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

    @BindingAdapter("android:text")
    public static void bindIntegerInText(EditText tv, int value)
    {
        tv.setText(String.valueOf(value));

        // Set the cursor to the end of the text
        tv.setSelection(tv.getText().length());
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Integer parseViewInt(EditText view) {
        Integer value = 0;
        try {
            value = Integer.parseInt(view.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

}

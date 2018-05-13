package com.rjdeleon.mvp_app;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.InverseBindingAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Modules.DNCAList.DNCAListAdapter;

import java.util.List;

public class AppUtil {

    public static void hideSoftKeyboard(Activity activity) {
        final InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        if (inputMethodManager.isActive()) {

            View focusedView = activity.getCurrentFocus();
            if (focusedView != null) {
                inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
                focusedView.clearFocus();
            }
        }
    }

    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static AgeGroupDataRow.AgeGroup stringToAgeGroup(String str) {
        if (str.endsWith("0-5")) {
            return AgeGroupDataRow.AgeGroup.AGE_0_5;
        } else if (str.endsWith("6-9")) {
            return AgeGroupDataRow.AgeGroup.AGE_6_9;
        } else if (str.endsWith("10-12")) {
            return AgeGroupDataRow.AgeGroup.AGE_10_12;
        } else if (str.endsWith("13-17")) {
            return AgeGroupDataRow.AgeGroup.AGE_13_17;
        } else if (str.endsWith("18-59")) {
            return AgeGroupDataRow.AgeGroup.AGE_18_59;
        } else {
            return AgeGroupDataRow.AgeGroup.AGE_60_PLUS;
        }
    }

    @BindingAdapter("android:text")
    public static void bindIntegerInText(EditText view, int value)
    {
        view.setText(String.valueOf(value));

        // Set the cursor to the end of the text
        view.setSelection(view.getText().length());
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

    @BindingAdapter("android:text")
    public static void bindIntegerInText(TextView view, int value) {
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Integer parseViewInt(TextView view) {
        Integer value = 0;
        try {
            value = Integer.parseInt(view.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    @BindingAdapter("android:text")
    public static void bindSimpleDateInText(TextView view, SimpleDate date) {
        view.setText(date.toString());
    }

    @BindingAdapter("currentItem")
    public static void setCurrentItem(ViewPager viewPager, int item) {
        viewPager.setCurrentItem(item);
    }

    @InverseBindingAdapter(attribute = "currentItem")
    public static int getCurrentItem(ViewPager viewPager) {
        return viewPager.getCurrentItem();
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<DNCAListItem> items) {
        DNCAListAdapter adapter = (DNCAListAdapter) recyclerView.getAdapter();
        if (adapter != null)
        {
            adapter.replaceItems(items);
        }
    }
}

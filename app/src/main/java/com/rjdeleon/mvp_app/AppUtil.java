package com.rjdeleon.mvp_app;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Models.Wash.WaterLevelRemarksTuple;
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
    public static void bindFloatInText(EditText view, float value)
    {
        view.setText(String.valueOf(value));

        // Set the cursor to the end of the text
        view.setSelection(view.getText().length());
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Float parseViewFloat(EditText view) {
        Float value = 0f;
        try {
            value = Float.parseFloat(view.getText().toString());
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

    @BindingAdapter({"enumList", "spinnerVisibility"})
    public static void bindAgeGroupListInAddButton(FloatingActionButton button, List<GenericEnum> enums, boolean shouldShowSpinner) {
        button.setEnabled(enums.size() > 0 || !shouldShowSpinner);
    }

    @BindingAdapter("android:text")
    public static void bindLivelihoodsEnumInText(TextView view, List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> list) {
        String text = "";
        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {
            if (list.get(i).isAffected) {
                text += list.get(i).subType.toString() + ", ";
            }
        }
        if (text.isEmpty()) {
            text = "None";
        } else {
            // Remove last comma and space
            text = text.substring(0, text.length()-2);
        }
        view.setText(text);
    }

    @BindingAdapter("android:checkedButton")
    public static void bindWaterLevelEnumInRadioGroup(RadioGroup radioGroup, int waterLevel) {
        for(int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            radioButton.setChecked(waterLevel == WaterLevelRemarksTuple.WaterLevel.fromString(radioButton.getText().toString()).ordinal());
        }
    }

    @InverseBindingAdapter(attribute = "android:checkedButton")
    public static int getWaterLevelFromRadioGroup(RadioGroup radioGroup) {
        RadioButton radioButton = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        return WaterLevelRemarksTuple.WaterLevel.fromString(radioButton.getText().toString()).ordinal();
    }
}

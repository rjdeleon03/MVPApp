package com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseAgeGroupNavigator;

public abstract class BaseAgeGroupDialogViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected Context mContext;

    public final ObservableField<GenericEnum> type = new ObservableField<>();

    /**
     * Constructor
     * @param context
     */
    public BaseAgeGroupDialogViewModel(Context context) {
        mContext = context;
    }

    /**
     * Sets the base age group navigator
     * @param baseAgeGroupNavigator
     */
    public void setBaseAgeGroupNavigator(BaseAgeGroupNavigator baseAgeGroupNavigator) {
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
    }

    /**
     * Handles navigation when Cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        if (mBaseAgeGroupNavigator != null) {
            mBaseAgeGroupNavigator.onDialogCloseButtonPressed();
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        mBaseAgeGroupNavigator.onDialogOkButtonPressed();
    }
}

package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;

public abstract class BaseEnumDialogViewModel {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected Context mContext;

    public final ObservableField<GenericEnum> type = new ObservableField<>();

    /**
     * Constructor
     * @param context
     */
    public BaseEnumDialogViewModel(Context context) {
        mContext = context;
    }

    /**
     * Sets the base age group navigator
     * @param baseEnumNavigator
     */
    public void setBaseAgeGroupNavigator(BaseEnumNavigator baseEnumNavigator) {
        mBaseEnumNavigator = baseEnumNavigator;
    }

    /**
     * Handles navigation when Cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        if (mBaseEnumNavigator != null) {
            mBaseEnumNavigator.onDialogCloseButtonPressed();
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        if (mBaseEnumNavigator != null) {
            mBaseEnumNavigator.onDialogOkButtonPressed();
        }
    }
}

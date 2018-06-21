package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;

public abstract class RowViewModel extends DialogViewModel {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected int mRowIndex;

    /**
     * Constructor
     * @param context
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public RowViewModel(Context context,
                        BaseEnumNavigator baseEnumNavigator,
                        int rowIndex) {

        super(context);
        mBaseEnumNavigator = baseEnumNavigator;
        mRowIndex = rowIndex;
    }

    /**
     * Handle navigation when card is selected
     */
    public void navigateOnCardSelected() {
        mBaseEnumNavigator.onCardSelected(mRowIndex);
    }

    /**
     * Handle navigation when card is deleted
     */
    public void navigateOnDeleteCardButtonPressed() {
        mBaseEnumNavigator.onDeleteCardButtonPressed();
    }
}

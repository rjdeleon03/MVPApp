package com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public abstract class BaseEnumRowViewModel extends NewDncaBaseViewModel {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected int mRowIndex;

    public final ObservableField<GenericEnum> type = new ObservableField<>();

    /**
     * Constructor
     * @param context
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public BaseEnumRowViewModel(Context context, BaseEnumNavigator baseEnumNavigator, int rowIndex) {
        super(context);
        mRowIndex = rowIndex;
        mBaseEnumNavigator = baseEnumNavigator;
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

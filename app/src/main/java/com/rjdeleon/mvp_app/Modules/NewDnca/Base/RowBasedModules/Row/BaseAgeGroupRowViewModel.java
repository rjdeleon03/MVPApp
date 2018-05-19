package com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public abstract class BaseAgeGroupRowViewModel extends NewDncaBaseViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected int mRowIndex;

    public final ObservableField<GenericEnum> type = new ObservableField<>();

    /**
     * Constructor
     * @param context
     * @param baseAgeGroupNavigator
     * @param rowIndex
     */
    public BaseAgeGroupRowViewModel(Context context, BaseAgeGroupNavigator baseAgeGroupNavigator, int rowIndex) {
        super(context);
        mRowIndex = rowIndex;
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
    }

    /**
     * Handle navigation when card is selected
     */
    public void navigateOnCardSelected() {
        mBaseAgeGroupNavigator.onCardSelected(mRowIndex);
    }

    /**
     * Handle navigation when card is deleted
     */
    public void navigateOnDeleteCardButtonPressed() {
        mBaseAgeGroupNavigator.onDeleteCardButtonPressed();
    }
}

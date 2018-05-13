package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Row;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationRepositoryManager;

public abstract class BaseAgeGroupRowViewModel extends NewDncaBaseViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected int mRowIndex;

    public final ObservableField<AgeGroupDataRow.AgeGroup> ageGroup = new ObservableField<>();

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

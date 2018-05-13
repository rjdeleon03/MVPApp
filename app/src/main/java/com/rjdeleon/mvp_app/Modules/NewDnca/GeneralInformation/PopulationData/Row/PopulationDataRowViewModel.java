package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataRowViewModel extends NewDncaBaseViewModel {

    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;
    private BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    private int mRowIndex;

    public final ObservableField<PopulationData.AgeGroup> ageGroup;
    public final ObservableInt totalMale;
    public final ObservableInt totalFemale;
    public final ObservableInt affectedMale;
    public final ObservableInt affectedFemale;
    public final ObservableInt displacedMale;
    public final ObservableInt displacedFemale;

    /**
     * Constructor
     * @param context
     * @param populationDataRepositoryManager
     * @param rowIndex
     */
    public PopulationDataRowViewModel(Context context,
                                      PopulationDataRepositoryManager populationDataRepositoryManager,
                                      BaseAgeGroupNavigator baseAgeGroupNavigator,
                                      int rowIndex) {
        super(context);
        mRowIndex = rowIndex;
        mPopulationDataRepositoryManager = populationDataRepositoryManager;
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;

        PopulationDataRow populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(mRowIndex);
        ageGroup = new ObservableField<>(populationDataRow.getAgeGroup());
        totalMale = new ObservableInt(populationDataRow.getTotal().male);
        totalFemale = new ObservableInt(populationDataRow.getTotal().female);
        affectedMale = new ObservableInt(populationDataRow.getAffected().male);
        affectedFemale = new ObservableInt(populationDataRow.getAffected().female);
        displacedMale = new ObservableInt(populationDataRow.getDisplaced().male);
        displacedFemale = new ObservableInt(populationDataRow.getDisplaced().female);
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
        mPopulationDataRepositoryManager.deletePopulationDataRow(mRowIndex);
        mBaseAgeGroupNavigator.onDeleteCardButtonPressed();
    }

}

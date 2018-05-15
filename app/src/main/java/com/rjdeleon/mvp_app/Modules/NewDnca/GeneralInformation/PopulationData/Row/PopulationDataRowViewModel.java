package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Row.BaseAgeGroupRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataRowViewModel extends BaseAgeGroupRowViewModel {

    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;

    public final ObservableField<GenericEnum> ageGroup = new ObservableField<>();
    public final ObservableInt totalMale = new ObservableInt(0);
    public final ObservableInt totalFemale = new ObservableInt(0);
    public final ObservableInt affectedMale = new ObservableInt(0);
    public final ObservableInt affectedFemale = new ObservableInt(0);
    public final ObservableInt displacedMale = new ObservableInt(0);
    public final ObservableInt displacedFemale = new ObservableInt(0);

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

        super(context, baseAgeGroupNavigator, rowIndex);
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        PopulationDataRow populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(mRowIndex);
        ageGroup.set(populationDataRow.getAgeGroup());
        totalMale.set(populationDataRow.getTotal().male);
        totalFemale.set(populationDataRow.getTotal().female);
        affectedMale.set(populationDataRow.getAffected().male);
        affectedFemale.set(populationDataRow.getAffected().female);
        displacedMale.set(populationDataRow.getDisplaced().male);
        displacedFemale.set(populationDataRow.getDisplaced().female);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mPopulationDataRepositoryManager.deletePopulationDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }

}

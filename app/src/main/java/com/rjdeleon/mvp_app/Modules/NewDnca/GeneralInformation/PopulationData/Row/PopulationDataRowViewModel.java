package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataRowViewModel extends BaseEnumRowViewModel {

    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public PopulationDataRowViewModel(Context context,
                                      PopulationDataRepositoryManager populationDataRepositoryManager,
                                      BaseEnumNavigator baseEnumNavigator,
                                      int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        PopulationDataRow populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(mRowIndex);
        type.set(populationDataRow.getType());
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

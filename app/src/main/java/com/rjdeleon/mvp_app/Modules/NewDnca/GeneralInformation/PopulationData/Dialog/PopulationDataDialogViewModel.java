package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseAgeGroupDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataDialogViewModel extends BaseAgeGroupDialogViewModel {

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
     * @param ageGroupIndex
     * @param isNewRow
     */
    public PopulationDataDialogViewModel(Context context,
                                         PopulationDataRepositoryManager populationDataRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super(context);
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        if (isNewRow) {
            type.set(mPopulationDataRepositoryManager.getPopulationDataAgeGroup(ageGroupIndex));
        } else {
            PopulationDataRow populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(ageGroupIndex);
            type.set(populationDataRow.getType());
            totalMale.set(populationDataRow.getTotal().male);
            totalFemale.set(populationDataRow.getTotal().female);
            affectedMale.set(populationDataRow.getAffected().male);
            affectedFemale.set(populationDataRow.getAffected().female);
            displacedMale.set(populationDataRow.getDisplaced().male);
            displacedFemale.set(populationDataRow.getDisplaced().female);
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        PopulationDataRow populationDataRow = new PopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                new GenderTuple(totalMale.get(), totalFemale.get()),
                new GenderTuple(affectedMale.get(), affectedFemale.get()),
                new GenderTuple(displacedMale.get(), displacedFemale.get())
        );
        mPopulationDataRepositoryManager.addPopulationDataRow(populationDataRow);
        super.navigateOnOkButtonPressed();
    }
}

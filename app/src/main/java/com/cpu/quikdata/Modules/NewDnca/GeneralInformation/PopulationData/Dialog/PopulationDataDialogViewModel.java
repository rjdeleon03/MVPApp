package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataDialogViewModel extends BaseEnumDialogViewModel {

    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;

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
                new GenderTuple(affectedMale.get() + displacedMale.get(),
                        affectedFemale.get() + displacedFemale.get()),
                new GenderTuple(affectedMale.get(), affectedFemale.get()),
                new GenderTuple(displacedMale.get(), displacedFemale.get()));

        mPopulationDataRepositoryManager.addPopulationDataRow(populationDataRow);
        super.navigateOnOkButtonPressed();
    }
}

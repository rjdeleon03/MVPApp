package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class PopulationDataDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<PopulationDataRow, GenericEnumDataRow.AgeGroup> mPopulationDataRepositoryManager;

    private String[] mQuestions = {
            "Affected",
            "Displaced"
    };

    /**
     * Constructor
     * @param populationDataRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public PopulationDataDialogViewModel(BaseEnumRepositoryManager<PopulationDataRow, GenericEnumDataRow.AgeGroup> populationDataRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {

        super();
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        PopulationDataRow populationDataRow;
        if (isNewRow) {
            populationDataRow = new PopulationDataRow(mPopulationDataRepositoryManager.getEnumType(ageGroupIndex));
        } else {
            populationDataRow = mPopulationDataRepositoryManager.getRow(ageGroupIndex);
        }
        type.set(populationDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], populationDataRow.getAffected().male, populationDataRow.getAffected().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], populationDataRow.getDisplaced().male, populationDataRow.getDisplaced().female)));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DialogItemViewModelGenderTuple affectedViewModel = (DialogItemViewModelGenderTuple)mItemViewModels.get(0);
        DialogItemViewModelGenderTuple displacedViewModel = (DialogItemViewModelGenderTuple)mItemViewModels.get(1);

        PopulationDataRow populationDataRow = new PopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                new GenderTuple(
                        affectedViewModel.value1.get() + displacedViewModel.value1.get(),
                        affectedViewModel.value2.get() + displacedViewModel.value2.get()),
                new GenderTuple(affectedViewModel.value1.get(), affectedViewModel.value2.get()),
                new GenderTuple(displacedViewModel.value1.get(), displacedViewModel.value2.get()));
        mPopulationDataRepositoryManager.addRow(populationDataRow);
        super.navigateOnOkButtonPressed();
    }
}

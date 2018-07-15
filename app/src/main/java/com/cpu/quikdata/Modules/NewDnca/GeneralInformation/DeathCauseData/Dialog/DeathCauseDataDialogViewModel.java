package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog;

import com.cpu.quikdata.Models.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class DeathCauseDataDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<DeathCauseDataRow, GenericEnumDataRow.AgeGroup> mDeathCauseRepositoryManager;

    private String[] mQuestions = {
            "Measles",
            "Diarrhea",
            "Pneumonia",
            "Dengue",
            "Drowning",
            "Heart Attack",
            "Electrocution",
            "Collapsed building",
            "Others"
    };

    /**
     * Constructor
     * @param deathCauseRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public DeathCauseDataDialogViewModel(BaseEnumRepositoryManager<DeathCauseDataRow, GenericEnumDataRow.AgeGroup> deathCauseRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super();
        mDeathCauseRepositoryManager = deathCauseRepositoryManager;

        DeathCauseDataRow deathCauseDataRow;
        if (isNewRow) {
            deathCauseDataRow = new DeathCauseDataRow(mDeathCauseRepositoryManager.getEnumType(ageGroupIndex));
        } else {
            deathCauseDataRow = mDeathCauseRepositoryManager.getRow(ageGroupIndex);
        }
        type.set(deathCauseDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], deathCauseDataRow.getMeasles().male, deathCauseDataRow.getMeasles().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], deathCauseDataRow.getDiarrhea().male, deathCauseDataRow.getDiarrhea().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[2], deathCauseDataRow.getPneumonia().male, deathCauseDataRow.getPneumonia().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[3], deathCauseDataRow.getDengue().male, deathCauseDataRow.getDengue().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[4], deathCauseDataRow.getDrowning().male, deathCauseDataRow.getDrowning().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[5], deathCauseDataRow.getHeartAttack().male, deathCauseDataRow.getHeartAttack().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[6], deathCauseDataRow.getElectrocution().male, deathCauseDataRow.getElectrocution().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[7], deathCauseDataRow.getCollapsedBuilding().male, deathCauseDataRow.getCollapsedBuilding().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[7], deathCauseDataRow.getOthers().male, deathCauseDataRow.getOthers().female)));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DialogItemViewModelGenderTuple measles = (DialogItemViewModelGenderTuple) mItemViewModels.get(0);
        DialogItemViewModelGenderTuple diarrhea = (DialogItemViewModelGenderTuple) mItemViewModels.get(1);
        DialogItemViewModelGenderTuple pneumonia = (DialogItemViewModelGenderTuple) mItemViewModels.get(2);
        DialogItemViewModelGenderTuple dengue = (DialogItemViewModelGenderTuple) mItemViewModels.get(3);
        DialogItemViewModelGenderTuple drowning = (DialogItemViewModelGenderTuple) mItemViewModels.get(4);
        DialogItemViewModelGenderTuple heartAttack = (DialogItemViewModelGenderTuple) mItemViewModels.get(5);
        DialogItemViewModelGenderTuple electrocution = (DialogItemViewModelGenderTuple) mItemViewModels.get(6);
        DialogItemViewModelGenderTuple collapsedBuilding = (DialogItemViewModelGenderTuple) mItemViewModels.get(7);
        DialogItemViewModelGenderTuple others = (DialogItemViewModelGenderTuple) mItemViewModels.get(8);

        DeathCauseDataRow deathCauseDataRow = new DeathCauseDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                new GenderTuple(measles.value1.get(), measles.value2.get()),
                new GenderTuple(diarrhea.value1.get(), diarrhea.value2.get()),
                new GenderTuple(pneumonia.value1.get(), pneumonia.value2.get()),
                new GenderTuple(dengue.value1.get(), dengue.value2.get()),
                new GenderTuple(drowning.value1.get(), drowning.value2.get()),
                new GenderTuple(heartAttack.value1.get(), heartAttack.value2.get()),
                new GenderTuple(electrocution.value1.get(), electrocution.value2.get()),
                new GenderTuple(collapsedBuilding.value1.get(), collapsedBuilding.value2.get()),
                new GenderTuple(others.value1.get(), others.value2.get())
        );
        mDeathCauseRepositoryManager.addRow(deathCauseDataRow);
        super.navigateOnOkButtonPressed();
    }
}

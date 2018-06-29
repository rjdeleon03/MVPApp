package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Row;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseRepositoryManager;

public class DeathCauseDataRowViewModel extends RowViewModel {

    private DeathCauseRepositoryManager mDeathCauseRepositoryManager;

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public DeathCauseDataRowViewModel(DeathCauseRepositoryManager deathCauseRepositoryManager,
                                      BaseEnumNavigator baseEnumNavigator,
                                      int rowIndex) {

        super(baseEnumNavigator, rowIndex);
        mDeathCauseRepositoryManager = deathCauseRepositoryManager;

        DeathCauseDataRow deathCauseDataRow = mDeathCauseRepositoryManager.getDeathCauseDataRow(mRowIndex);
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
                new DialogItemModelGenderTuple(mQuestions[8], deathCauseDataRow.getOthers().male, deathCauseDataRow.getOthers().female)));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mDeathCauseRepositoryManager.deleteDeathCauseDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }

}

package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Row;

import com.cpu.quikdata.Models.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class DeathCauseDataRowViewModel extends RowViewModel {
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
     * Generates new instance
     * @return
     */
    public static DeathCauseDataRowViewModel newInstance() {
        return new DeathCauseDataRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public DeathCauseDataRowViewModel() {
        super();
    }

    /**
     * Sets the relevant variables to obtain data row
     * @param baseEnumNavigator
     * @param repositoryManager
     * @param rowIndex
     */
    @Override
    public void setData(BaseEnumNavigator baseEnumNavigator, BaseEnumRepositoryManager repositoryManager, int rowIndex) {
        super.setData(baseEnumNavigator, repositoryManager, rowIndex);

        DeathCauseDataRow deathCauseDataRow = (DeathCauseDataRow) mRepositoryManager.getRow(mRowIndex);
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
        mRepositoryManager.deleteRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }

}

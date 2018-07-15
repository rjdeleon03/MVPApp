package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row;

import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class DiseasesInjuriesRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "NUMBER OF CASES OF ILLNESSES",
            "Diarrhea",
            "Pneumonia",
            "Dengue",
            "Measles",
            "Others",
            "MEDICAL NEEDS",
            "Check-up",
            "Hospitalization",
            "Medicines",
            "Others"
    };

    /**
     * Generates new instance
     * @return
     */
    public static DiseasesInjuriesRowViewModel newInstance() {
        return new DiseasesInjuriesRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public DiseasesInjuriesRowViewModel() {
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

        DiseasesInjuriesDataRow diseasesInjuriesDataRow = (DiseasesInjuriesDataRow) mRepositoryManager.getRow(rowIndex);
        type.set(diseasesInjuriesDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelDivider(
                new DialogItemModelDivider(mQuestions[0], true)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], diseasesInjuriesDataRow.getMeasles().male, diseasesInjuriesDataRow.getMeasles().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[2], diseasesInjuriesDataRow.getDiarrhea().male, diseasesInjuriesDataRow.getDiarrhea().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[3], diseasesInjuriesDataRow.getPneumonia().male, diseasesInjuriesDataRow.getPneumonia().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[4], diseasesInjuriesDataRow.getDengue().male, diseasesInjuriesDataRow.getDengue().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[5], diseasesInjuriesDataRow.getIllOthers().male, diseasesInjuriesDataRow.getIllOthers().female)));
        mItemViewModels.add(new DialogItemViewModelDivider(
                new DialogItemModelDivider(mQuestions[6], true)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[7], diseasesInjuriesDataRow.getCheckUp().male, diseasesInjuriesDataRow.getCheckUp().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[8], diseasesInjuriesDataRow.getHospitalization().male, diseasesInjuriesDataRow.getHospitalization().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[9], diseasesInjuriesDataRow.getMedicines().male, diseasesInjuriesDataRow.getMedicines().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[10], diseasesInjuriesDataRow.getMedOthers().male, diseasesInjuriesDataRow.getMedOthers().female)));
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

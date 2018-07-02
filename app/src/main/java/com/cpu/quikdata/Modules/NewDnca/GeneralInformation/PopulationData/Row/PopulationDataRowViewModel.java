package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class PopulationDataRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "Total",
            "Affected",
            "Displaced"
    };

    /**
     * Generates new instance
     * @return
     */
    public static PopulationDataRowViewModel newInstance() {
        return new PopulationDataRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public PopulationDataRowViewModel() {
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

        PopulationDataRow populationDataRow = (PopulationDataRow) mRepositoryManager.getRow(mRowIndex);
        type.set(populationDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], populationDataRow.getTotal().male, populationDataRow.getTotal().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], populationDataRow.getAffected().male, populationDataRow.getAffected().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[2], populationDataRow.getDisplaced().male, populationDataRow.getDisplaced().female)));
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

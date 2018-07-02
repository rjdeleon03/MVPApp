package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class CasualtiesDataRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "Dead",
            "Missing",
            "Injured"
    };

    /**
     * Generates new instance
     * @return
     */
    public static CasualtiesDataRowViewModel newInstance() {
        return new CasualtiesDataRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public CasualtiesDataRowViewModel() {
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

        CasualtiesDataRow casualtiesDataRow = (CasualtiesDataRow) mRepositoryManager.getRow(mRowIndex);
        type.set(casualtiesDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[0], casualtiesDataRow.getDead().male, casualtiesDataRow.getDead().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[1], casualtiesDataRow.getMissing().male, casualtiesDataRow.getMissing().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[2], casualtiesDataRow.getInjured().male, casualtiesDataRow.getInjured().female)));

    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    // TODO: Refactor this
    public void navigateOnDeleteCardButtonPressed() {
        mRepositoryManager.deleteRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

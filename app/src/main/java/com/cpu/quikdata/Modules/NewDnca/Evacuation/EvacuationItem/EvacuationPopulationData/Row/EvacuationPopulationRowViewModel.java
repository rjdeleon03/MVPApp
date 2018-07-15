package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.Row;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class EvacuationPopulationRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "Male",
            "Female",
            "LGBT",
            "Pregnant Women",
            "Lactating Mothers",
            "Persons with Disabilities",
            "Sick"
    };

    /**
     * Generates new instance
     * @return
     */
    public static EvacuationPopulationRowViewModel newInstance() {
        return new EvacuationPopulationRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public EvacuationPopulationRowViewModel() {
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

        EvacuationPopulationDataRow evacuationPopulationDataRow = (EvacuationPopulationDataRow) mRepositoryManager.getRow(mRowIndex);
        type.set(evacuationPopulationDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[0], evacuationPopulationDataRow.getMale())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], evacuationPopulationDataRow.getFemale())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[2], evacuationPopulationDataRow.getLgbt())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[3], evacuationPopulationDataRow.getPregnant())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[4], evacuationPopulationDataRow.getLactating())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[5], evacuationPopulationDataRow.getDisabled())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[6], evacuationPopulationDataRow.getSick())));
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

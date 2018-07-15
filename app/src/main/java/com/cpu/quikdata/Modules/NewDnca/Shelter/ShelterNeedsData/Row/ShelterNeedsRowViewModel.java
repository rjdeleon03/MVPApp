package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row;

import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class ShelterNeedsRowViewModel extends RowViewModel {

    private String[] mQuestions = {
            "Identify Specific Items",
            "Number of Families in Need"
    };

    /**
     * Generates new instance
     * @return
     */
    public static ShelterNeedsRowViewModel newInstance() {
        return new ShelterNeedsRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public ShelterNeedsRowViewModel() {
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

        ShelterNeedsDataRow shelterNeedsDataRow = (ShelterNeedsDataRow) mRepositoryManager.getRow(rowIndex);
        type.set(shelterNeedsDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[0], shelterNeedsDataRow.getItems())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], shelterNeedsDataRow.getFamilyCount(), true)));
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

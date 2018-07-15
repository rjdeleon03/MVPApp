package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row;

import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class SpecialNeedsRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "Number of People with Special Needs",
            "Health/Medical Needs"
    };

    /**
     * Generates new instance
     * @return
     */
    public static SpecialNeedsRowViewModel newInstance() {
        return new SpecialNeedsRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public SpecialNeedsRowViewModel() {
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

        SpecialNeedsDataRow specialNeedsDataRow = (SpecialNeedsDataRow) mRepositoryManager.getRow(rowIndex);
        type.set(specialNeedsDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[0], specialNeedsDataRow.getCount(), true)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[1], specialNeedsDataRow.getNeeds())));
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

package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class InfrastructureDamageRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "Infrastructure Count",
            "Functional?",
            "Remarks"
    };

    /**
     * Generates new instance
     * @return
     */
    public static InfrastructureDamageRowViewModel newInstance() {
        return new InfrastructureDamageRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public InfrastructureDamageRowViewModel() {
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

        InfrastructureDamageDataRow infrastructureDamageDataRow = (InfrastructureDamageDataRow) mRepositoryManager.getRow(rowIndex);
        type.set(infrastructureDamageDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[0], infrastructureDamageDataRow.getDamaged())));
        mItemViewModels.add(new DialogItemViewModelBoolean(
                new DialogItemModelBoolean(mQuestions[1], infrastructureDamageDataRow.isFunctional())));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[2], infrastructureDamageDataRow.getRemarks())));

        // TODO: Hide remarks if empty
//        shouldShowRemarks.set(remarks.get().trim().length() > 0);
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

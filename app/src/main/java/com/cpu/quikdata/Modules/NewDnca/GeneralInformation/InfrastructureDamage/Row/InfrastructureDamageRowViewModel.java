package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageRepositoryManager;

public class InfrastructureDamageRowViewModel extends RowViewModel {

    private InfrastructureDamageRepositoryManager mInfrastructureDamageRepositoryManager;

    private String[] mQuestions = {
            "Infrastructure Count",
            "Functional?",
            "Remarks"
    };


    /**
     * Constructor
     * @param infrastructureDamageRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public InfrastructureDamageRowViewModel(InfrastructureDamageRepositoryManager infrastructureDamageRepositoryManager,
                                            BaseEnumNavigator baseEnumNavigator,
                                            int rowIndex) {

        super(baseEnumNavigator, rowIndex);
        mInfrastructureDamageRepositoryManager = infrastructureDamageRepositoryManager;

        InfrastructureDamageDataRow infrastructureDamageDataRow = mInfrastructureDamageRepositoryManager.getInfrastructureDamageRow(rowIndex);
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
        mInfrastructureDamageRepositoryManager.deleteInfrastructureDamageRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

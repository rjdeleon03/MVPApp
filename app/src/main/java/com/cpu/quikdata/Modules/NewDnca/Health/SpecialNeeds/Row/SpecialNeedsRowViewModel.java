package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsRepositoryManager;

public class SpecialNeedsRowViewModel extends RowViewModel {

    private SpecialNeedsRepositoryManager mSpecialNeedsRepositoryManager;

    private String[] mQuestions = {
            "Number of People with Special Needs",
            "Health/Medical Needs"
    };

    /**
     * Constructor
     * @param context
     * @param specialNeedsRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public SpecialNeedsRowViewModel(Context context,
                                    SpecialNeedsRepositoryManager specialNeedsRepositoryManager,
                                    BaseEnumNavigator baseEnumNavigator,
                                    int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mSpecialNeedsRepositoryManager = specialNeedsRepositoryManager;

        SpecialNeedsDataRow specialNeedsDataRow = mSpecialNeedsRepositoryManager.getSpecialNeedsDataRow(rowIndex);
        type.set(specialNeedsDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[0], specialNeedsDataRow.getCount(), true)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[1], specialNeedsDataRow.getNeeds())));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mSpecialNeedsRepositoryManager.deleteSpecialNeedsDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

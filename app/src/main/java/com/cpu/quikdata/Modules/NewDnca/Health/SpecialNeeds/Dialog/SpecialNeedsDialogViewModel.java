package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsRepositoryManager;

public class SpecialNeedsDialogViewModel extends DialogViewModel {

    private SpecialNeedsRepositoryManager mSpecialNeedsRepositoryManager;

    private String[] mQuestions = {
        "Number of People with Special Needs",
        "Health/Medical Needs"
    };


    /**
     * Constructor
     * @param context
     * @param specialNeedsRepositoryManager
     * @param specialNeedsIndex
     * @param isNewRow
     */
    public SpecialNeedsDialogViewModel(Context context,
                                       SpecialNeedsRepositoryManager specialNeedsRepositoryManager,
                                       int specialNeedsIndex,
                                       boolean isNewRow) {
        super(context);
        mSpecialNeedsRepositoryManager = specialNeedsRepositoryManager;

        SpecialNeedsDataRow specialNeedsDataRow;
        if (isNewRow) {
            specialNeedsDataRow = new SpecialNeedsDataRow(mSpecialNeedsRepositoryManager.getSpecialNeedsDataType(specialNeedsIndex));
        } else {
            specialNeedsDataRow = mSpecialNeedsRepositoryManager.getSpecialNeedsDataRow(specialNeedsIndex);
        }

        type.set(specialNeedsDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[0], specialNeedsDataRow.getCount(), true)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[1], specialNeedsDataRow.getNeeds())));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        SpecialNeedsDataRow specialNeedsDataRow = new SpecialNeedsDataRow(
                (GenericEnumDataRow.SpecialNeedsType) type.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(1)).value1.get());

        mSpecialNeedsRepositoryManager.addSpecialNeedsDataRow(specialNeedsDataRow);
        super.navigateOnOkButtonPressed();
    }
}

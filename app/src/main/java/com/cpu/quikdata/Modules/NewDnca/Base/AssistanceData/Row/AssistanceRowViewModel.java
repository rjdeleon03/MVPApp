package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.RowViewModel;

public class AssistanceRowViewModel extends RowViewModel {

    private AssistanceDataRepositoryManager mAssistanceDataRepositoryManager;

    private String[] mQuestions = {
            "Name of Organization or Agency",
            "Type of Assistance",
            "Date Received",
            "Quantity or Amount",
            "BENEFICIARIES",
            "Men",
            "Women",
            "Boys",
            "Girls"
    };

    /**
     * Constructor
     * @param context
     * @param assistanceDataRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public AssistanceRowViewModel(Context context,
                                  AssistanceDataRepositoryManager assistanceDataRepositoryManager,
                                  BaseEnumNavigator baseEnumNavigator,
                                  int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mAssistanceDataRepositoryManager = assistanceDataRepositoryManager;

        AssistanceDataRow assistanceDataRow = mAssistanceDataRepositoryManager.getAssistanceDataRow(rowIndex);

        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[0], assistanceDataRow.getOrgName())));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[1], assistanceDataRow.getAssistanceType())));
        mItemViewModels.add(new DialogItemViewModelDate(
                new DialogItemModelDate(mQuestions[2], assistanceDataRow.getDateReceived())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[3], assistanceDataRow.getAmount(), true)));
        mItemViewModels.add(new DialogItemViewModelDivider(
                new DialogItemModelDivider(mQuestions[4], true)));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[5], assistanceDataRow.getBeneficiariesMen())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[6], assistanceDataRow.getBeneficiariesWomen())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[7], assistanceDataRow.getBeneficiariesBoys())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[8], assistanceDataRow.getBeneficiariesGirls())));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mAssistanceDataRepositoryManager.deleteAssistanceDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class AssistanceDialogViewModel extends DialogViewModel {

    private AssistanceDataRepositoryManager mAssistanceDataRepositoryManager;
    private int mRowIndex;

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
     * Default constructor
     * @param context
     * @param assistanceDataRepositoryManager
     * @param rowIndex
     */
    public AssistanceDialogViewModel(Context context,
                                     AssistanceDataRepositoryManager assistanceDataRepositoryManager,
                                     int rowIndex) {
        super(context);
        mAssistanceDataRepositoryManager = assistanceDataRepositoryManager;
        mRowIndex = rowIndex;

        AssistanceDataRow assistanceDataRow;
        if (mRowIndex == -1) {
            assistanceDataRow = new AssistanceDataRow();
        } else {
            assistanceDataRow = mAssistanceDataRepositoryManager.getAssistanceDataRow(rowIndex);
        }

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
     * Constructor for new rows
     * @param context
     * @param assistanceDataRepositoryManager
     */
    public AssistanceDialogViewModel(Context context,
                                     AssistanceDataRepositoryManager assistanceDataRepositoryManager) {
        this(context, assistanceDataRepositoryManager, -1);
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        AssistanceDataRow assistanceDataRow = new AssistanceDataRow(
                ((DialogItemViewModelRemarks) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(1)).value1.get(),
                ((DialogItemViewModelDate) mItemViewModels.get(2)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(3)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(5)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(6)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(7)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(8)).value1.get());

        mAssistanceDataRepositoryManager.addAssistanceDataRow(assistanceDataRow, mRowIndex);
        super.navigateOnOkButtonPressed();
    }
}

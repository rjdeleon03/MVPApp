package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelDivider;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class AssistanceRowViewModel extends RowViewModel implements DialogItemDataSource {

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
     * Generates new instance
     * @return
     */
    public static AssistanceRowViewModel newInstance() {
        return new AssistanceRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public AssistanceRowViewModel() {
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

        AssistanceDataRow assistanceDataRow = (AssistanceDataRow) mRepositoryManager.getRow(rowIndex);

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
        mRepositoryManager.deleteRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

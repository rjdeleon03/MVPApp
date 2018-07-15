package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class LivelihoodsIncomeRowViewModel extends RowViewModel {

    private String[] mQuestions = {
            "Source of Income",
            "Number of Dependent Households",
            "Dependent Males",
            "Dependent Females",
            "Dependent Boys",
            "Dependent Girls",
            "Average Monthly or Daily Income per Household (PHP)"
    };

    /**
     * Generates new instance
     * @return
     */
    public static LivelihoodsIncomeRowViewModel newInstance() {
        return new LivelihoodsIncomeRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public LivelihoodsIncomeRowViewModel() {
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

        LivelihoodsIncomeDataRow incomeDataRow = (LivelihoodsIncomeDataRow) mRepositoryManager.getRow(rowIndex);
        type.set(incomeDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[0], incomeDataRow.getSource())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], incomeDataRow.getDepHousehold(), true)));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[2], incomeDataRow.getDepMale())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[3], incomeDataRow.getDepFemale())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[4], incomeDataRow.getDepBoys())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[5], incomeDataRow.getDepGirls())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[6], incomeDataRow.getAverageIncome(), true)));
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

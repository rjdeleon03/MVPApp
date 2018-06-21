package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeRepositoryManager;

public class LivelihoodsIncomeRowViewModel extends RowViewModel {

    private LivelihoodsIncomeRepositoryManager mLivelihoodsIncomeRepositoryManager;

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
     * Constructor
     * @param context
     * @param livelihoodsIncomeRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public LivelihoodsIncomeRowViewModel(Context context,
                                         LivelihoodsIncomeRepositoryManager livelihoodsIncomeRepositoryManager,
                                         BaseEnumNavigator baseEnumNavigator,
                                         int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mLivelihoodsIncomeRepositoryManager = livelihoodsIncomeRepositoryManager;

        LivelihoodsIncomeDataRow incomeDataRow = mLivelihoodsIncomeRepositoryManager.getIncomeBeforeRow(rowIndex);
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
        mLivelihoodsIncomeRepositoryManager.deleteIncomeBeforeRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

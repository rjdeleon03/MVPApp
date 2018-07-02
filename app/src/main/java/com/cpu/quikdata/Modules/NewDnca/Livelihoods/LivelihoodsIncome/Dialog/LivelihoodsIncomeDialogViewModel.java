package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeViewModel;

public class LivelihoodsIncomeDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<LivelihoodsIncomeDataRow, GenericEnumDataRow.IncomeSourceType> mLivelihoodsIncomeRepositoryManager;
    private boolean mIsNewRow;
    private int mRowIndex = -1;

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
     * @param livelihoodsIncomeRepositoryManager
     * @param incomeSourceTypeIndex
     * @param isNewRow
     */
    public LivelihoodsIncomeDialogViewModel(BaseEnumRepositoryManager<LivelihoodsIncomeDataRow, GenericEnumDataRow.IncomeSourceType> livelihoodsIncomeRepositoryManager,
                                            int incomeSourceTypeIndex,
                                            boolean isNewRow) {
        super();
        mLivelihoodsIncomeRepositoryManager = livelihoodsIncomeRepositoryManager;
        mIsNewRow = isNewRow;

        LivelihoodsIncomeDataRow incomeDataRow;
        if (mIsNewRow) {
            incomeDataRow = new LivelihoodsIncomeDataRow(mLivelihoodsIncomeRepositoryManager.getEnumType(incomeSourceTypeIndex));
        } else {
            mRowIndex = incomeSourceTypeIndex;
            incomeDataRow = mLivelihoodsIncomeRepositoryManager.getRow(incomeSourceTypeIndex);
        }

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
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        LivelihoodsIncomeDataRow livelihoodsIncomeDataRow = new LivelihoodsIncomeDataRow(
                (GenericEnumDataRow.IncomeSourceType) type.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(1)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(2)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(3)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(4)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(5)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(6)).value1.get());

        // TODO: Refactor this
        ((LivelihoodsIncomeViewModel) mLivelihoodsIncomeRepositoryManager).addRow(livelihoodsIncomeDataRow, mRowIndex);

        super.navigateOnOkButtonPressed();
    }
}

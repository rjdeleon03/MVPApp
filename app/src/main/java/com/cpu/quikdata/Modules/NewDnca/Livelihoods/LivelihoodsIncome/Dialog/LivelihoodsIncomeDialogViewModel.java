package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeRepositoryManager;

public class LivelihoodsIncomeDialogViewModel extends BaseEnumDialogViewModel {

    private LivelihoodsIncomeRepositoryManager mLivelihoodsIncomeRepositoryManager;
    private boolean mIsNewRow;
    private int mRowIndex = -1;

    public final ObservableField<String> source = new ObservableField<>("");
    public final ObservableInt depHousehold= new ObservableInt(0);
    public final ObservableInt depMale= new ObservableInt(0);
    public final ObservableInt depFemale= new ObservableInt(0);
    public final ObservableInt depBoys= new ObservableInt(0);
    public final ObservableInt depGirls= new ObservableInt(0);
    public final ObservableInt averageIncome= new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param livelihoodsIncomeRepositoryManager
     * @param incomeSourceTypeIndex
     * @param isNewRow
     */
    public LivelihoodsIncomeDialogViewModel(Context context,
                                            LivelihoodsIncomeRepositoryManager livelihoodsIncomeRepositoryManager,
                                            int incomeSourceTypeIndex,
                                            boolean isNewRow) {
        super(context);
        mLivelihoodsIncomeRepositoryManager = livelihoodsIncomeRepositoryManager;
        mIsNewRow = isNewRow;

        if (mIsNewRow) {
            type.set(mLivelihoodsIncomeRepositoryManager.getIncomeBeforeSourceType(incomeSourceTypeIndex));
        } else {
            mRowIndex = incomeSourceTypeIndex;

            LivelihoodsIncomeDataRow incomeDataRow = mLivelihoodsIncomeRepositoryManager.getIncomeBeforeRow(incomeSourceTypeIndex);
            type.set(incomeDataRow.getType());
            source.set(incomeDataRow.getSource());
            depHousehold.set(incomeDataRow.getDepHousehold());
            depMale.set(incomeDataRow.getDepMale());
            depFemale.set(incomeDataRow.getDepFemale());
            depBoys.set(incomeDataRow.getDepBoys());
            depGirls.set(incomeDataRow.getDepGirls());
            averageIncome.set(incomeDataRow.getAverageIncome());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        LivelihoodsIncomeDataRow livelihoodsIncomeDataRow = new LivelihoodsIncomeDataRow(
                (GenericEnumDataRow.IncomeSourceType) type.get(),
                source.get(),
                depHousehold.get(),
                depMale.get(),
                depFemale.get(),
                depBoys.get(),
                depGirls.get(),
                averageIncome.get());
        mLivelihoodsIncomeRepositoryManager.addIncomeBeforeRow(livelihoodsIncomeDataRow, mRowIndex);
        super.navigateOnOkButtonPressed();
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.IncomeBeforeRepositoryManager;

public class IncomeBeforeDialogViewModel extends BaseEnumDialogViewModel {

    private IncomeBeforeRepositoryManager mIncomeBeforeRepositoryManager;
    private boolean mIsNewRow = false;
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
     * @param incomeBeforeRepositoryManager
     * @param incomeSourceTypeIndex
     * @param isNewRow
     */
    public IncomeBeforeDialogViewModel(Context context, 
                                       IncomeBeforeRepositoryManager incomeBeforeRepositoryManager,
                                       int incomeSourceTypeIndex,
                                       boolean isNewRow) {
        super(context);
        mIncomeBeforeRepositoryManager = incomeBeforeRepositoryManager;
        mIsNewRow = isNewRow;

        if (mIsNewRow) {
            type.set(mIncomeBeforeRepositoryManager.getIncomeBeforeSourceType(incomeSourceTypeIndex));
        } else {
            mRowIndex = incomeSourceTypeIndex;

            LivelihoodsIncomeDataRow incomeDataRow = mIncomeBeforeRepositoryManager.getIncomeBeforeRow(incomeSourceTypeIndex);
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
        mIncomeBeforeRepositoryManager.addIncomeBeforeRow(livelihoodsIncomeDataRow, mRowIndex);
        super.navigateOnOkButtonPressed();
    }
}

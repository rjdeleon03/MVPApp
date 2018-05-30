package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.IncomeBeforeRepositoryManager;

public class IncomeBeforeRowViewModel extends BaseEnumRowViewModel {

    private IncomeBeforeRepositoryManager mIncomeBeforeRepositoryManager;

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public IncomeBeforeRowViewModel(Context context,
                                    IncomeBeforeRepositoryManager incomeBeforeRepositoryManager,
                                    BaseEnumNavigator baseEnumNavigator,
                                    int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mIncomeBeforeRepositoryManager = incomeBeforeRepositoryManager;

        LivelihoodsIncomeDataRow incomeDataRow = mIncomeBeforeRepositoryManager.getIncomeBeforeRow(rowIndex);
        type.set(incomeDataRow.getType());
        source.set(incomeDataRow.getSource());
        depHousehold.set(incomeDataRow.getDepHousehold());
        depMale.set(incomeDataRow.getDepMale());
        depFemale.set(incomeDataRow.getDepFemale());
        depBoys.set(incomeDataRow.getDepBoys());
        depGirls.set(incomeDataRow.getDepGirls());
        averageIncome.set(incomeDataRow.getAverageIncome());
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mIncomeBeforeRepositoryManager.deleteIncomeBeforeRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}

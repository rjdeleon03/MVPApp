package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeData;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsEnumBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

import java.util.List;

public class IncomeBeforeViewModel extends LivelihoodsEnumBaseViewModel implements IncomeBeforeRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public IncomeBeforeViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager, GenericEnumDataRow.IncomeSourceType.class);
        mGenericEnumDataRows.addAll(mLivelihoodsRepositoryManager.getLivelihoodsIncomeBeforeEmergency().getLivelihoodsIncomeDataRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsIncomeData incomeData = new LivelihoodsIncomeData();
        incomeData.setLivelihoodsIncomeDataRows((List<LivelihoodsIncomeDataRow>)(Object) mGenericEnumDataRows);
        mLivelihoodsRepositoryManager.saveLivelihoodsIncomeBeforeEmergency(incomeData);
    }

    @Override
    public void addIncomeBeforeRow(LivelihoodsIncomeDataRow livelihoodsIncomeDataRow, int rowIndex) {
        if (rowIndex == -1) {
            mGenericEnumDataRows.add(livelihoodsIncomeDataRow);
        } else {
            mGenericEnumDataRows.set(rowIndex, livelihoodsIncomeDataRow);
        }
    }

    @Override
    public void deleteIncomeBeforeRow(int rowIndex) {
        mGenericEnumDataRows.remove(rowIndex);
    }

    @Override
    public LivelihoodsIncomeDataRow getIncomeBeforeRow(int rowIndex) {
        return (LivelihoodsIncomeDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    @Override
    public GenericEnumDataRow.IncomeSourceType getIncomeBeforeSourceType(int needsTypeIndex) {
        return (GenericEnumDataRow.IncomeSourceType) ageGroupList.get(needsTypeIndex);
    }
}

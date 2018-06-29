package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

import java.util.List;

public class LivelihoodsIncomeViewModel extends LivelihoodsEnumBaseViewModel implements LivelihoodsIncomeRepositoryManager {

    private boolean mWillSaveAsIncomeBefore = false;

    /**
     * Constructor
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsIncomeViewModel(LivelihoodsRepositoryManager livelihoodsRepositoryManager, boolean willSaveAsIncomeBefore) {
        super(livelihoodsRepositoryManager, GenericEnumDataRow.IncomeSourceType.class);
        mWillSaveAsIncomeBefore = willSaveAsIncomeBefore;

        if (mWillSaveAsIncomeBefore) {
            mGenericEnumDataRows.addAll(mLivelihoodsRepositoryManager.getLivelihoodsIncomeBeforeEmergency().getLivelihoodsIncomeDataRows());
        } else {
            mGenericEnumDataRows.addAll(mLivelihoodsRepositoryManager.getLivelihoodsIncomeAfterEmergency().getLivelihoodsIncomeDataRows());
        }
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsIncomeData incomeData = new LivelihoodsIncomeData();
        incomeData.setLivelihoodsIncomeDataRows((List<LivelihoodsIncomeDataRow>)(Object) mGenericEnumDataRows);

        if (mWillSaveAsIncomeBefore) {
            mLivelihoodsRepositoryManager.saveLivelihoodsIncomeBeforeEmergency(incomeData);
        } else {
            mLivelihoodsRepositoryManager.saveLivelihoodsIncomeAfterEmergency(incomeData);
        }
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

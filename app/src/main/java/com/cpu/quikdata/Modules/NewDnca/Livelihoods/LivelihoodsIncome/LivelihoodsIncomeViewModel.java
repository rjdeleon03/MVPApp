package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumNoTypeRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

import java.util.List;

public class LivelihoodsIncomeViewModel extends LivelihoodsEnumBaseViewModel implements BaseEnumNoTypeRepositoryManager<LivelihoodsIncomeDataRow, GenericEnumDataRow.IncomeSourceType> {

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

    /**
     * Adds livelihoods income source row
     *
     * @param row
     */
    @Override
    public void addRow(LivelihoodsIncomeDataRow row) {
        mGenericEnumDataRows.add(row);
    }

    // TODO: Refactor this
    public void addRow(LivelihoodsIncomeDataRow row, int rowIndex) {
        if (rowIndex == -1) {
            mGenericEnumDataRows.add(row);
        } else {
            mGenericEnumDataRows.set(rowIndex, row);
        }

    }

    /**
     * Deletes livelihoods income source row
     *
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        mGenericEnumDataRows.remove(rowIndex);
    }

    /**
     * Gets livelihoods income source row
     *
     * @param rowIndex
     */
    @Override
    public LivelihoodsIncomeDataRow getRow(int rowIndex) {
        return (LivelihoodsIncomeDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets livelihoods income source row based on index
     *
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.IncomeSourceType getEnumType(int typeIndex) {
        return (GenericEnumDataRow.IncomeSourceType) ageGroupList.get(typeIndex);
    }
}

package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

import java.util.List;

public class LivelihoodsDamageViewModel extends LivelihoodsEnumBaseViewModel implements BaseEnumRepositoryManager<LivelihoodsDamageDataRow, GenericEnumDataRow.LivelihoodsType> {

    /**
     * Constructor
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsDamageViewModel(LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(livelihoodsRepositoryManager, GenericEnumDataRow.LivelihoodsType.class);
        mGenericEnumDataRows.addAll(mLivelihoodsRepositoryManager.getLivelihoodsDamageData().getLivelihoodsDamageDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsDamageData damageData = new LivelihoodsDamageData();
        damageData.setLivelihoodsDamageDataRows((List<LivelihoodsDamageDataRow>)(Object) mGenericEnumDataRows);
        mLivelihoodsRepositoryManager.saveLivelihoodsDamageData(damageData);
    }

    /**
     * Adds livelihood damage row
     *
     * @param row
     */
    @Override
    public void addRow(LivelihoodsDamageDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes livelihood damage row
     *
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets livelihoods damage row
     *
     * @param rowIndex
     * @return
     */
    @Override
    public LivelihoodsDamageDataRow getRow(int rowIndex) {
        return (LivelihoodsDamageDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets livelihoods type based on index
     *
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.LivelihoodsType getEnumType(int typeIndex) {
        return (GenericEnumDataRow.LivelihoodsType) ageGroupList.get(typeIndex);
    }
}

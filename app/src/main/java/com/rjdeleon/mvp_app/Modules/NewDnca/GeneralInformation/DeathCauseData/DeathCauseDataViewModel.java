package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class DeathCauseDataViewModel extends GenInfoEnumBaseViewModel implements DeathCauseRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param genInfoRepositoryManager
     */
    public DeathCauseDataViewModel(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
        super(context, genInfoRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mGenInfoRepositoryManager.getDeathCauseData().getDeathCauseDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        DeathCauseData deathCauseData = new DeathCauseData();
        deathCauseData.setDeathCauseDataRows((List<DeathCauseDataRow>)(Object) mGenericEnumDataRows);
        mGenInfoRepositoryManager.saveDeathCauseData(deathCauseData);
    }

    /**
     * Adds death cause data row
     * @param deathCauseDataRow
     */
    @Override
    public void addDeathCauseDataRow(DeathCauseDataRow deathCauseDataRow) {
        super.addAgeGroupDataRow(deathCauseDataRow);
    }

    /**
     * Deletes death cause data row
     * @param rowIndex
     */
    @Override
    public void deleteDeathCauseDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets death cause data row
     * @param rowIndex
     */
    @Override
    public DeathCauseDataRow getDeathCauseDataRow(int rowIndex) {
        return (DeathCauseDataRow) mGenericEnumDataRows.get(rowIndex);
    }
    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

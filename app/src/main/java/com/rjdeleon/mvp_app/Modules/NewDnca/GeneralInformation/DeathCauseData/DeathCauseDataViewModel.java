package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.List;

public class DeathCauseDataViewModel extends BaseAgeGroupViewModel implements DeathCauseRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public DeathCauseDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        mAgeGroupDataRows.addAll(mNewDncaGenInfoRepositoryManager.getDeathCauseData().getDeathCauseDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        DeathCauseData deathCauseData = new DeathCauseData();
        deathCauseData.setDeathCauseDataRows((List<DeathCauseDataRow>)(Object) mAgeGroupDataRows);
        mNewDncaGenInfoRepositoryManager.saveDeathCauseData(deathCauseData);
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
        return (DeathCauseDataRow) mAgeGroupDataRows.get(rowIndex);
    }
    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public AgeGroupDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex) {
        return ageGroupList.get(ageGroupIndex);
    }
}

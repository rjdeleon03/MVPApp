package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;
import android.databinding.ObservableBoolean;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.List;

public class VulnerablePopulationViewModel extends BaseAgeGroupViewModel implements VulnerablePopulationRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public VulnerablePopulationViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        mAgeGroupDataRows.addAll(mNewDncaGenInfoRepositoryManager.getVulnerablePopulation().getVulnerablePopulationDataRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        VulnerablePopulationData vulnerablePopulationData = new VulnerablePopulationData();
        vulnerablePopulationData.setVulnerablePopulationDataRows((List<VulnerablePopulationDataRow>)(Object) mAgeGroupDataRows);
        mNewDncaGenInfoRepositoryManager.saveVulnerablePopulation(vulnerablePopulationData);
    }

    /**
     * Adds vulnerable population data row
     * @param vulnerablePopulationDataRow
     */
    @Override
    public void addVulnerablePopulationRow(VulnerablePopulationDataRow vulnerablePopulationDataRow) {
        super.addAgeGroupDataRow(vulnerablePopulationDataRow);
    }

    /**
     * Deletes vulnerable population data row
     * @param rowIndex
     */
    @Override
    public void deleteVulnerablePopulationRow(int rowIndex) {
        super.deletePopulationDataRow(rowIndex);
    }

    /**
     * Gets vulnerable population data row
     * @param rowIndex
     */
    @Override
    public VulnerablePopulationDataRow getVulnerablePopulationRow(int rowIndex) {
        return (VulnerablePopulationDataRow) mAgeGroupDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public AgeGroupDataRow.AgeGroup getVulnerablePopulationAgeGroup(int ageGroupIndex) {
        return mAgeGroupList.get(ageGroupIndex);
    }
}

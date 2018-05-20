package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.List;

public class VulnerablePopulationViewModel extends BaseEnumViewModel implements VulnerablePopulationRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public VulnerablePopulationViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mNewDncaGenInfoRepositoryManager.getVulnerablePopulation().getVulnerablePopulationDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        VulnerablePopulationData vulnerablePopulationData = new VulnerablePopulationData();
        vulnerablePopulationData.setVulnerablePopulationDataRows((List<VulnerablePopulationDataRow>)(Object) mGenericEnumDataRows);
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
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets vulnerable population data row
     * @param rowIndex
     */
    @Override
    public VulnerablePopulationDataRow getVulnerablePopulationRow(int rowIndex) {
        return (VulnerablePopulationDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getVulnerablePopulationAgeGroup(int ageGroupIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

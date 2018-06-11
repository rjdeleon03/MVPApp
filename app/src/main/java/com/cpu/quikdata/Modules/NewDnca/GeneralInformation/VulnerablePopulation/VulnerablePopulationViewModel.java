package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationData;
import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class VulnerablePopulationViewModel extends GenInfoEnumBaseViewModel implements VulnerablePopulationRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param genInfoRepositoryManager
     */
    public VulnerablePopulationViewModel(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
        super(context, genInfoRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mGenInfoRepositoryManager.getVulnerablePopulation().getVulnerablePopulationDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        VulnerablePopulationData vulnerablePopulationData = new VulnerablePopulationData();
        vulnerablePopulationData.setVulnerablePopulationDataRows((List<VulnerablePopulationDataRow>)(Object) mGenericEnumDataRows);
        mGenInfoRepositoryManager.saveVulnerablePopulation(vulnerablePopulationData);
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

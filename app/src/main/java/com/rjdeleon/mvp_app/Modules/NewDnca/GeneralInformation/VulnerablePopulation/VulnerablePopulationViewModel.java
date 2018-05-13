package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class VulnerablePopulationViewModel extends BaseAgeGroupViewModel implements VulnerablePopulationRepositoryManager {

    private List<VulnerablePopulationDataRow> mVulnerablePopulationRows = new ArrayList<>();

    /**
     * Constructor
     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public VulnerablePopulationViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        mVulnerablePopulationRows.addAll(mNewDncaGenInfoRepositoryManager.getVulnerablePopulation().getVulnerablePopulationDataRows());

        // Remove items from age group list if age group is already in use
        for(VulnerablePopulationDataRow row : mVulnerablePopulationRows) {
            for (PopulationData.AgeGroup ageGroup : mAgeGroupList) {
                if (ageGroup.ordinal() == row.getAgeGroup().ordinal()) {
                    mAgeGroupList.remove(ageGroup);
                    break;
                }
            }
        }
    }

    /**
     * Retrieves vulnerable population data rows count
     * @return
     */
    public int getVulnerablePopulationRowsCount() {
        return mVulnerablePopulationRows.size();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        VulnerablePopulationData vulnerablePopulationData = new VulnerablePopulationData();
        vulnerablePopulationData.setVulnerablePopulationDataRows(mVulnerablePopulationRows);
        mNewDncaGenInfoRepositoryManager.saveVulnerablePopulation(vulnerablePopulationData);
    }

    /**
     * Adds vulnerable population data row
     * @param vulnerablePopulationDataRow
     */
    @Override
    public void addVulnerablePopulationRow(VulnerablePopulationDataRow vulnerablePopulationDataRow) {

    }

    /**
     * Deletes vulnerable population data row
     * @param rowIndex
     */
    @Override
    public void deleteVulnerablePopulationRow(int rowIndex) {

    }

    /**
     * Gets vulnerable population data row
     * @param rowIndex
     */
    @Override
    public VulnerablePopulationDataRow getVulnerablePopulationRow(int rowIndex) {
        return mVulnerablePopulationRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public PopulationData.AgeGroup getVulnerablePopulationAgeGroup(int ageGroupIndex) {
        return mAgeGroupList.get(ageGroupIndex);
    }
}

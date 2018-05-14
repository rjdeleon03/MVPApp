package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.List;

public class  PopulationDataViewModel extends BaseAgeGroupViewModel implements PopulationDataRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public PopulationDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        mAgeGroupDataRows.addAll(mNewDncaGenInfoRepositoryManager.getPopulationData().getPopulationDataRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        PopulationData populationData = new PopulationData();
        populationData.setPopulationDataRows((List<PopulationDataRow>)(Object) mAgeGroupDataRows);
        mNewDncaGenInfoRepositoryManager.savePopulationData(populationData);
    }

    /**
     * Adds population data row
     * @param populationDataRow
     */
    @Override
    public void addPopulationDataRow(PopulationDataRow populationDataRow) {
        super.addAgeGroupDataRow(populationDataRow);
    }

    /**
     * Deletes population data row
     * @param rowIndex
     */
    @Override
    public void deletePopulationDataRow(int rowIndex) {
        super.deletePopulationDataRow(rowIndex);
    }

    /**
     * Gets population data row
     * @param rowIndex
     */
    @Override
    public PopulationDataRow getPopulationDataRow(int rowIndex) {
        return (PopulationDataRow) mAgeGroupDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public AgeGroupDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex) {
        return mAgeGroupList.get(ageGroupIndex);
    }
}

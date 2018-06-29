package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class PopulationDataViewModel extends GenInfoEnumBaseViewModel implements PopulationDataRepositoryManager {

    /**
     * Constructor
     * @param genInfoRepositoryManager
     */
    public PopulationDataViewModel(GenInfoRepositoryManager genInfoRepositoryManager) {
        super(genInfoRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mGenInfoRepositoryManager.getPopulationData().getPopulationDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        PopulationData populationData = new PopulationData((List<PopulationDataRow>)(Object) mGenericEnumDataRows);
        mGenInfoRepositoryManager.savePopulationData(populationData);
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
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets population data row
     * @param rowIndex
     */
    @Override
    public PopulationDataRow getPopulationDataRow(int rowIndex) {
        return (PopulationDataRow) mGenericEnumDataRows.get(rowIndex);
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

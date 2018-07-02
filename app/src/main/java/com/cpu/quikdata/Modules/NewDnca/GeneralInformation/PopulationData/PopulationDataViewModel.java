package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class PopulationDataViewModel extends GenInfoEnumBaseViewModel implements BaseEnumRepositoryManager<PopulationDataRow, GenericEnumDataRow.AgeGroup> {

    /**
     * Constructor
     *
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
        PopulationData populationData = new PopulationData((List<PopulationDataRow>) (Object) mGenericEnumDataRows);
        mGenInfoRepositoryManager.savePopulationData(populationData);
    }

    /**
     * Adds population data row
     *
     * @param row
     */
    @Override
    public void addRow(PopulationDataRow row) {
        super.addAgeGroupDataRow(row);
    }


    /**
     * Deletes population data row
     *
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets population data row
     *
     * @param rowIndex
     */
    @Override
    public PopulationDataRow getRow(int rowIndex) {
        return (PopulationDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     *
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getEnumType(int typeIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(typeIndex);
    }
}

package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationData;
import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;

import java.util.List;

public class EvacuationPopulationViewModel extends EvacuationEnumBaseViewModel implements BaseEnumRepositoryManager<EvacuationPopulationDataRow, GenericEnumDataRow.AgeGroup> {

    /**
     * Constructor
     * @param evacuationItemRepositoryManager
     */
    public EvacuationPopulationViewModel(EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(evacuationItemRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mEvacuationItemRepositoryManager.getPopulationData().getEvacuationPopulationDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        EvacuationPopulationData evacuationPopulationData = new EvacuationPopulationData((List<EvacuationPopulationDataRow>)(Object) mGenericEnumDataRows);
        mEvacuationItemRepositoryManager.savePopulationData(evacuationPopulationData);
    }

    /**
     * Adds evacuation population data row
     * @param row
     */
    @Override
    public void addRow(EvacuationPopulationDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes evacuation population data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }
    /**
     * Gets evacuation population data row
     * @param rowIndex
     * @return
     */
    @Override
    public EvacuationPopulationDataRow getRow(int rowIndex) {
        return (EvacuationPopulationDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getEnumType(int typeIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(typeIndex);
    }
}

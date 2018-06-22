package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationData;
import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;

import java.util.List;

public class EvacuationPopulationViewModel extends EvacuationEnumBaseViewModel implements EvacuationPopulationRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param evacuationItemRepositoryManager
     */
    public EvacuationPopulationViewModel(Context context, EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(context, evacuationItemRepositoryManager, GenericEnumDataRow.AgeGroup.class);
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
     * @param evacuationPopulationDataRow
     */
    @Override
    public void addEvacuationPopulationDataRow(EvacuationPopulationDataRow evacuationPopulationDataRow) {
        super.addAgeGroupDataRow(evacuationPopulationDataRow);
    }

    /**
     * Deletes evacuation population data row
     * @param rowIndex
     */
    @Override
    public void deleteEvacuationPopulationDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets evacuation population data row
     * @param rowIndex
     * @return
     */
    @Override
    public EvacuationPopulationDataRow getEvacuationPopulationDataRow(int rowIndex) {
        return (EvacuationPopulationDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getEvacuationPopulationDataAgeGroup(int ageGroupIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

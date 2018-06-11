package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationData;
import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationRepositoryManager;

import java.util.List;

import javax.annotation.Nullable;

public class EvacuationPopulationViewModel extends EvacuationEnumBaseViewModel implements EvacuationPopulationRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param evacuationRepositoryManager
     */
    public EvacuationPopulationViewModel(Context context, EvacuationRepositoryManager evacuationRepositoryManager) {
        super(context, evacuationRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mEvacuationRepositoryManager.getPopulationData().getEvacuationPopulationDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        EvacuationPopulationData evacuationPopulationData = new EvacuationPopulationData((List<EvacuationPopulationDataRow>)(Object) mGenericEnumDataRows);
        mEvacuationRepositoryManager.savePopulationData(evacuationPopulationData);
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

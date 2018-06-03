package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData;

import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationPopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public interface EvacuationPopulationRepositoryManager {

    void addEvacuationPopulationDataRow(EvacuationPopulationDataRow evacuationPopulationDataRow);

    void deleteEvacuationPopulationDataRow(int rowIndex);

    EvacuationPopulationDataRow getEvacuationPopulationDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getEvacuationPopulationDataAgeGroup(int ageGroupIndex);
}

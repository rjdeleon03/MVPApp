package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface EvacuationPopulationRepositoryManager {

    void addEvacuationPopulationDataRow(EvacuationPopulationDataRow evacuationPopulationDataRow);

    void deleteEvacuationPopulationDataRow(int rowIndex);

    EvacuationPopulationDataRow getEvacuationPopulationDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getEvacuationPopulationDataAgeGroup(int ageGroupIndex);
}

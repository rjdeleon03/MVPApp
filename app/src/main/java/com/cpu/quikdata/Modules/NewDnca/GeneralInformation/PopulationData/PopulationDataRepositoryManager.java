package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface PopulationDataRepositoryManager {

    void addPopulationDataRow(PopulationDataRow populationDataRow);

    void deletePopulationDataRow(int rowIndex);

    PopulationDataRow getPopulationDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex);
}

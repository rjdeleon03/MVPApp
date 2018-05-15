package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public interface PopulationDataRepositoryManager {

    void addPopulationDataRow(PopulationDataRow populationDataRow);

    void deletePopulationDataRow(int rowIndex);

    PopulationDataRow getPopulationDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex);
}

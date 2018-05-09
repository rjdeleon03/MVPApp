package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

public interface PopulationDataRootViewModel {

    void addPopulationDataRow(PopulationDataRow populationDataRow);

    PopulationDataRow getPopulationDataRow(int rowIndex);

    PopulationData.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex);
}

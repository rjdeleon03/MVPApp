package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;

import java.util.List;

public interface PopulationDataRepositoryManager {

    void addPopulationDataRow(PopulationDataRow populationDataRow);

    void deletePopulationDataRow(int rowIndex);

    PopulationDataRow getPopulationDataRow(int rowIndex);

    AgeGroupDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex);

    List<AgeGroupDataRow.AgeGroup> getAgeGroups();
}

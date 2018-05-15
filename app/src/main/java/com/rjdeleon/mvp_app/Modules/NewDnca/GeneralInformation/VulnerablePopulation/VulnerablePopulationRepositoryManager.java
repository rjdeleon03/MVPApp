package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public interface VulnerablePopulationRepositoryManager {

    void addVulnerablePopulationRow(VulnerablePopulationDataRow vulnerablePopulationDataRow);

    void deleteVulnerablePopulationRow(int rowIndex);

    VulnerablePopulationDataRow getVulnerablePopulationRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getVulnerablePopulationAgeGroup(int ageGroupIndex);

}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;

public interface VulnerablePopulationRepositoryManager {

    void addVulnerablePopulationRow(VulnerablePopulationDataRow vulnerablePopulationDataRow);

    void deleteVulnerablePopulationRow(int rowIndex);

    VulnerablePopulationDataRow getVulnerablePopulationRow(int rowIndex);

    PopulationData.AgeGroup getVulnerablePopulationAgeGroup(int ageGroupIndex);

}

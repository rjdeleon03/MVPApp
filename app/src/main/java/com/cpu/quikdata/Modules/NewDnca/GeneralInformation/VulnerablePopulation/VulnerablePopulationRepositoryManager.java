package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface VulnerablePopulationRepositoryManager {

    void addVulnerablePopulationRow(VulnerablePopulationDataRow vulnerablePopulationDataRow);

    void deleteVulnerablePopulationRow(int rowIndex);

    VulnerablePopulationDataRow getVulnerablePopulationRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getVulnerablePopulationAgeGroup(int ageGroupIndex);

}

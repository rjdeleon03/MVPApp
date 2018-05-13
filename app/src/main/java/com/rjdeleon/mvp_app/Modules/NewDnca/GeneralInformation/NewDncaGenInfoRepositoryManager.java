package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;

public interface NewDncaGenInfoRepositoryManager {

    CalamityDesc getCalamityDetails();

    PopulationData getPopulationData();

    FamilyData getFamilyData();

    VulnerablePopulationData getVulnerablePopulation();

    void saveCalamityDetails(CalamityDesc calamityDesc);

    void savePopulationData(PopulationData populationData);

    void saveFamilyData(FamilyData familyData);

    void saveVulnerablePopulation(VulnerablePopulationData vulnerablePopulationData);
}

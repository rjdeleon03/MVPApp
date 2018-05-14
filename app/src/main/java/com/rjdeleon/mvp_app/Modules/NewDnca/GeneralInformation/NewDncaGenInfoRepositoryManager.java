package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;

public interface NewDncaGenInfoRepositoryManager {

    CalamityDesc getCalamityDetails();

    PopulationData getPopulationData();

    FamilyData getFamilyData();

    VulnerablePopulationData getVulnerablePopulation();

    CasualtiesData getCasualtiesData();

    DeathCauseData getDeathCauseData();

    InfrastructureDamageData getInfrastructureDamageData();

    void saveCalamityDetails(CalamityDesc calamityDesc);

    void savePopulationData(PopulationData populationData);

    void saveFamilyData(FamilyData familyData);

    void saveVulnerablePopulation(VulnerablePopulationData vulnerablePopulationData);

    void saveCasualtiesData(CasualtiesData casualtiesData);

    void saveDeathCauseData(DeathCauseData deathCauseData);

    void saveInfrastructureDamageData(InfrastructureDamageData infrastructureDamageData);
}

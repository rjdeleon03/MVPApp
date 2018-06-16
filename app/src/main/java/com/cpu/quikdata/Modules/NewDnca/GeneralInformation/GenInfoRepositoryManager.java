package com.cpu.quikdata.Modules.NewDnca.GeneralInformation;

import com.cpu.quikdata.Models.GeneralInformation.CalamityDesc;
import com.cpu.quikdata.Models.GeneralInformation.CasualtiesData;
import com.cpu.quikdata.Models.GeneralInformation.DeathCauseData;
import com.cpu.quikdata.Models.GeneralInformation.FamilyData;
import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageData;
import com.cpu.quikdata.Models.GeneralInformation.PopulationData;
import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationData;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

public interface GenInfoRepositoryManager extends RepositoryManager {

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

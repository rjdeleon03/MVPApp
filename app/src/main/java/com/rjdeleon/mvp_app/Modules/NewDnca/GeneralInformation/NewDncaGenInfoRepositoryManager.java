package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

public interface NewDncaGenInfoRepositoryManager {

    CalamityDesc getCalamityDetails();

    PopulationData getPopulationData();

    FamilyData getFamilyData();

    void saveCalamityDetails(CalamityDesc calamityDesc);

    void savePopulationData(PopulationData populationData);

    void saveFamilyData(FamilyData familyData);
}

package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation;

import com.rjdeleon.mvp_app.Models.Shelter.ShelterCopingData;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterGapsData;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageData;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;

public interface ShelterInfoRepositoryManager extends AssistanceDataContainer {

    ShelterHouseDamageData getHouseDamageData();

    ShelterCopingData getShelterCopingData();

    ShelterNeedsData getShelterNeedsData();

    ShelterGapsData getShelterGapsData();

    void saveHouseDamageData(ShelterHouseDamageData houseDamageData);

    void saveShelterCopingData(ShelterCopingData shelterCopingData);

    void saveShelterNeedsData(ShelterNeedsData shelterNeedsData);

    void saveShelterGapsData(ShelterGapsData shelterGapsData);
}

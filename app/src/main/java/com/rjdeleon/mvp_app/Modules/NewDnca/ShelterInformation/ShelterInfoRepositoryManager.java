package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterCopingData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterGapsData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterHouseDamageData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterNeedsData;

public interface ShelterInfoRepositoryManager {

    ShelterHouseDamageData getHouseDamageData();

    ShelterCopingData getShelterCopingData();

    ShelterNeedsData getShelterNeedsData();

    AssistanceData getShelterAssistanceData();

    ShelterGapsData getShelterGapsData();

    void saveHouseDamageData(ShelterHouseDamageData houseDamageData);

    void saveShelterCopingData(ShelterCopingData shelterCopingData);

    void saveShelterNeedsData(ShelterNeedsData shelterNeedsData);

    void saveShelterAssistanceData(AssistanceData assistanceData);

    void saveShelterGapsData(ShelterGapsData shelterGapsData);
}

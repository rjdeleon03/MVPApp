package com.cpu.quikdata.Modules.NewDnca.Shelter;

import com.cpu.quikdata.Models.Shelter.ShelterCopingData;
import com.cpu.quikdata.Models.Shelter.ShelterGapsData;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageData;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;

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

package com.cpu.quikdata.Modules.NewDnca.Health;

import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesData;
import com.cpu.quikdata.Models.Health.HealthGapsData;
import com.cpu.quikdata.Models.Health.PsychosocialData;
import com.cpu.quikdata.Models.Health.SpecialNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;

public interface HealthRepositoryManager extends AssistanceDataContainer, GenericCopingDataContainer {
    
    DiseasesInjuriesData getDiseasesInjuriesData();
    
    SpecialNeedsData getSpecialNeedsData();
    
    PsychosocialData getPsychosocialData();
    
    HealthGapsData getHealthGapsData();

    void saveDiseasesInjuriesData(DiseasesInjuriesData diseasesInjuriesData);

    void saveSpecialNeedsData(SpecialNeedsData specialNeedsData);

    void savePsychosocialData(PsychosocialData psychosocialData);

    void saveHealthGapsData(HealthGapsData healthGapsData);
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Health;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesData;
import com.rjdeleon.mvp_app.Models.Health.HealthGapsData;
import com.rjdeleon.mvp_app.Models.Health.PsychosocialData;
import com.rjdeleon.mvp_app.Models.Health.SpecialNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;

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

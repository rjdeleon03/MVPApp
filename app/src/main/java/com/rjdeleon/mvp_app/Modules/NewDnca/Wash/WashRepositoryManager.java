package com.rjdeleon.mvp_app.Modules.NewDnca.Wash;

import com.rjdeleon.mvp_app.Models.Wash.WashConditionsData;
import com.rjdeleon.mvp_app.Models.Wash.WashGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;

public interface WashRepositoryManager extends AssistanceDataContainer, GenericCopingDataContainer {

    WashConditionsData getWashConditionsData();

    WashGapsData getGapsData();

    void saveWashConditionsData(WashConditionsData washConditionsData);

    void saveGapsData(WashGapsData gapsData);
}

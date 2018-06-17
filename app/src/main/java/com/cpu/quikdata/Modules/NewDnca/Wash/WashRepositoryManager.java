package com.cpu.quikdata.Modules.NewDnca.Wash;

import com.cpu.quikdata.Models.Wash.WashConditionsData;
import com.cpu.quikdata.Models.Wash.WashGapsData;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

public interface WashRepositoryManager extends RepositoryManager, AssistanceDataContainer, GenericCopingDataContainer {

    WashConditionsData getWashConditionsData();

    WashGapsData getGapsData();

    void saveWashConditionsData(WashConditionsData washConditionsData);

    void saveGapsData(WashGapsData gapsData);
}

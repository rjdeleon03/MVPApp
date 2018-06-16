package com.cpu.quikdata.Modules.NewDnca.FoodSecurity;

import com.cpu.quikdata.Models.FoodSecurity.FoodGapsData;
import com.cpu.quikdata.Models.FoodSecurity.FoodImpactData;
import com.cpu.quikdata.Models.FoodSecurity.FoodNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

public interface FoodSecurityRepositoryManager extends RepositoryManager, AssistanceDataContainer, GenericCopingDataContainer {

    FoodImpactData getFoodImpactData();

    FoodNeedsData getFoodNeedsData();

    FoodGapsData getFoodGapsData();

    void saveFoodImpactData(FoodImpactData foodImpactData);

    void saveFoodNeedsData(FoodNeedsData foodNeedsData);

    void saveFoodGapsData(FoodGapsData foodGapsData);
}

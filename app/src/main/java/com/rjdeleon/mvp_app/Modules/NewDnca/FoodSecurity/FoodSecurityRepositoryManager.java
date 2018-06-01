package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodGapsData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;

public interface FoodSecurityRepositoryManager extends AssistanceDataContainer, GenericCopingDataContainer {

    FoodImpactData getFoodImpactData();

    FoodNeedsData getFoodNeedsData();

    FoodGapsData getFoodGapsData();

    void saveFoodImpactData(FoodImpactData foodImpactData);

    void saveFoodNeedsData(FoodNeedsData foodNeedsData);

    void saveFoodGapsData(FoodGapsData foodGapsData);
}

package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodGapsData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;

public interface FoodSecurityRepositoryManager extends AssistanceDataContainer {

    FoodImpactData getFoodImpactData();

    GenericCopingData getFoodCopingData();

    FoodNeedsData getFoodNeedsData();

    FoodGapsData getFoodGapsData();

    void saveFoodImpactData(FoodImpactData foodImpactData);

    void saveFoodCopingData(GenericCopingData foodCopingData);

    void saveFoodNeedsData(FoodNeedsData foodNeedsData);

    void saveFoodGapsData(FoodGapsData foodGapsData);
}

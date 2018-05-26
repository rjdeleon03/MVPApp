package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodCopingData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodGapsData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodNeedsData;
import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataRepositoryManager;

public interface FoodSecurityRepositoryManager extends AssistanceDataContainer {

    FoodImpactData getFoodImpactData();

    FoodCopingData getFoodCopingData();

    FoodNeedsData getFoodNeedsData();

    FoodGapsData getFoodGapsData();

    void saveFoodImpactData(FoodImpactData foodImpactData);

    void saveFoodCopingData(FoodCopingData foodCopingData);

    void saveFoodNeedsData(FoodNeedsData foodNeedsData);

    void saveFoodGapsData(FoodGapsData foodGapsData);
}

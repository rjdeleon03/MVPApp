package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodCopingData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodGapsData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodNeedsData;
import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;

public interface FoodSecurityRepositoryManager {

    FoodImpactData getFoodImpactData();

    FoodCopingData getFoodCopingData();

    FoodNeedsData getFoodNeedsData();

    AssistanceData getFoodAssistanceData();

    FoodGapsData getFoodGapsData();

    void saveFoodImpactData(FoodImpactData foodImpactData);

    void saveFoodCopingData(FoodCopingData foodCopingData);

    void saveFoodNeedsData(FoodNeedsData foodNeedsData);

    void saveFoodAssistanceData(AssistanceData foodAssistanceData);

    void saveFoodGapsData(FoodGapsData foodGapsData);
}

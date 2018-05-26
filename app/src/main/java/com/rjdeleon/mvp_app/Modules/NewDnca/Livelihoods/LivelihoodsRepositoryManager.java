package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsCopingData;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageData;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsGapsData;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsIncomeData;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;

public interface LivelihoodsRepositoryManager extends AssistanceDataContainer {

    LivelihoodsIncomeData getLivelihoodsIncomeBeforeEmergency();

    LivelihoodsIncomeData getLivelihoodsIncomeAfterEmergency();

    LivelihoodsDamageData getLivelihoodsDamageData();

    LivelihoodsCopingData getLivelihoodsCopingData();

    LivelihoodsNeedsData getLivelihoodsNeedsData();

    LivelihoodsGapsData getLivelihoodsGapsData();
    
    void saveLivelihoodsIncomeBeforeEmergency(LivelihoodsIncomeData livelihoodsIncomeData);
    
    void saveLivelihoodsIncomeAfterEmergency(LivelihoodsIncomeData livelihoodsIncomeData);
    
    void saveLivelihoodsDamageData(LivelihoodsDamageData livelihoodsDamageData);

    void saveLivelihoodsCopingData(LivelihoodsCopingData livelihoodsCopingData);

    void saveLivelihoodsNeedsData(LivelihoodsNeedsData livelihoodsNeedsData);

    void saveLivelihoodsGapsData(LivelihoodsGapsData livelihoodsGapsData);
}

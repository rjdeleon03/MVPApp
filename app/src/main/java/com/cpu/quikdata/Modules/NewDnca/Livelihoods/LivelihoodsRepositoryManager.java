package com.cpu.quikdata.Modules.NewDnca.Livelihoods;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsCopingData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsGapsData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeData;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

public interface LivelihoodsRepositoryManager extends RepositoryManager, AssistanceDataContainer {

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

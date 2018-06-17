package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import com.cpu.quikdata.Models.Evacuation.EvacuationFacilitiesData;
import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationData;
import com.cpu.quikdata.Models.Evacuation.EvacuationSecurityData;
import com.cpu.quikdata.Models.Evacuation.EvacuationSiteData;
import com.cpu.quikdata.Models.Evacuation.EvacuationWashData;
import com.cpu.quikdata.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;

public interface EvacuationRepositoryManager extends RepositoryManager, GenericCopingDataContainer {

    EvacuationSiteData getSiteData();

    EvacuationPopulationData getPopulationData();

    EvacuationFacilitiesData getFacilitiesData();

    EvacuationWashData getWashData();

    EvacuationSecurityData getSecurityData();

    void saveSiteData(EvacuationSiteData siteData);

    void savePopulationData(EvacuationPopulationData populationData);

    void saveFacilitiesData(EvacuationFacilitiesData facilitiesData);

    void saveWashData(EvacuationWashData washData);

    void saveSecurityData(EvacuationSecurityData securityData);
}

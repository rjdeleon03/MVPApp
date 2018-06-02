package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationFacilitiesData;
import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationPopulationData;
import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationSecurityData;
import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationSiteData;
import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationWashData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataContainer;

public interface EvacuationRepositoryManager extends GenericCopingDataContainer {

    EvacuationSiteData getSiteData();

    EvacuationPopulationData getPopulationData();

    EvacuationFacilitiesData getFaciliesData();

    EvacuationWashData getWashData();

    EvacuationSecurityData getSecurityData();

    void saveSiteData(EvacuationSiteData siteData);

    void savePopulationData(EvacuationPopulationData populationData);

    void saveFacilitiesData(EvacuationFacilitiesData facilitiesData);

    void saveWashData(EvacuationWashData washData);

    void saveSecurityData(EvacuationSecurityData securityData);
}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;

public interface NewDncaGenInfoRepositoryManager {

    CalamityDesc getCalamityDetails();

    PopulationData getPopulationData();
}

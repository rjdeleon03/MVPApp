package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;

import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;

public interface DeathCauseRepositoryManager {

    void addDeathCauseDataRow(DeathCauseDataRow deathCauseDataRow);

    void deleteDeathCauseDataRow(int rowIndex);

    DeathCauseDataRow getDeathCauseDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex);
}

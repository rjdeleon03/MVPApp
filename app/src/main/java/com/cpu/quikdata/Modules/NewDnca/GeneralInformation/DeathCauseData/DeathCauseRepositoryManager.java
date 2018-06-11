package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData;

import com.cpu.quikdata.Models.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface DeathCauseRepositoryManager {

    void addDeathCauseDataRow(DeathCauseDataRow deathCauseDataRow);

    void deleteDeathCauseDataRow(int rowIndex);

    DeathCauseDataRow getDeathCauseDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex);
}

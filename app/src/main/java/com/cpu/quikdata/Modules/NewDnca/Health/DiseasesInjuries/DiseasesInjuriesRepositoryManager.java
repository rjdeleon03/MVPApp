package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;

public interface DiseasesInjuriesRepositoryManager {

    void addDiseasesInjuriesDataRow(DiseasesInjuriesDataRow diseasesInjuriesDataRow);

    void deleteDiseasesInjuriesDataRow(int rowIndex);

    DiseasesInjuriesDataRow getDiseasesInjuriesDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getDiseasesInjuriesAgeGroup(int ageGroupIndex);
}

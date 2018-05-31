package com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesDataRow;

public interface DiseasesInjuriesRepositoryManager {

    void addDiseasesInjuriesDataRow(DiseasesInjuriesDataRow diseasesInjuriesDataRow);

    void deleteDiseasesInjuriesDataRow(int rowIndex);

    DiseasesInjuriesDataRow getDiseasesInjuriesDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getDiseasesInjuriesAgeGroup(int ageGroupIndex);
}

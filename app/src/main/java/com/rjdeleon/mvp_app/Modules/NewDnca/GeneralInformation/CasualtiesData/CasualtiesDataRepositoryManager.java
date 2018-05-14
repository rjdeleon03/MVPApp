package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;

public interface CasualtiesDataRepositoryManager {

    void addCasualtiesDataRow(CasualtiesDataRow casualtiesDataRow);

    void deleteCasualtiesDataRow(int rowIndex);

    CasualtiesDataRow getCasualtiesDataRow(int rowIndex);

    AgeGroupDataRow.AgeGroup getCasualtiesDataAgeGroup(int ageGroupIndex);
}

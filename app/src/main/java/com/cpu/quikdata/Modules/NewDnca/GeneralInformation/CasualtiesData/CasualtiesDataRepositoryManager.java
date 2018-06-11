package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;

public interface CasualtiesDataRepositoryManager {

    void addCasualtiesDataRow(CasualtiesDataRow casualtiesDataRow);

    void deleteCasualtiesDataRow(int rowIndex);

    CasualtiesDataRow getCasualtiesDataRow(int rowIndex);

    GenericEnumDataRow.AgeGroup getCasualtiesDataAgeGroup(int ageGroupIndex);
}

package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;

public interface ShelterNeedsRepositoryManager {

    void addShelterNeedsDataRow(ShelterNeedsDataRow shelterNeedsDataRow);

    void deleteShelterNeedsDataRow(int rowIndex);

    ShelterNeedsDataRow getShelterNeedsDataRow(int rowIndex);

    GenericEnumDataRow.NeedsType getShelterNeedsDataType(int needsTypeIndex);
}

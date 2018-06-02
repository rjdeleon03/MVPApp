package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterNeedsDataRow;

public interface ShelterNeedsRepositoryManager {

    void addShelterNeedsDataRow(ShelterNeedsDataRow shelterNeedsDataRow);

    void deleteShelterNeedsDataRow(int rowIndex);

    ShelterNeedsDataRow getShelterNeedsDataRow(int rowIndex);

    GenericEnumDataRow.NeedsType getShelterNeedsDataType(int needsTypeIndex);
}
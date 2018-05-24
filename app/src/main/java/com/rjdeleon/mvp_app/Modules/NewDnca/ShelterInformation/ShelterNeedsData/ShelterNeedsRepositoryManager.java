package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterNeedsData;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterNeedsDataRow;

public interface ShelterNeedsRepositoryManager {

    void addShelterNeedsDataRow(ShelterNeedsDataRow shelterNeedsDataRow);

    void deleteShelterNeedsDataRow(int rowIndex);

    ShelterNeedsDataRow getShelterNeedsDataRow(int rowIndex);

    GenericEnumDataRow.NeedsType getShelterNeedsDataType(int needsTypeIndex);
}

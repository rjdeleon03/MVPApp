package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageDataRow;

public interface HouseDamageRepositoryManager {

    void addHouseDamageDataRow(ShelterHouseDamageDataRow houseDamageDataRow);

    void deleteHouseDamageDataRow(int rowIndex);

    ShelterHouseDamageDataRow getHouseDamageDataRow(int rowIndex);

    GenericEnumDataRow.HouseType getHouseDamageDataHouseType(int houseTypeIndex);
}

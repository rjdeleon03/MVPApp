package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;

public interface HouseDamageRepositoryManager {

    void addHouseDamageDataRow(ShelterHouseDamageDataRow houseDamageDataRow);

    void deleteHouseDamageDataRow(int rowIndex);

    ShelterHouseDamageDataRow getHouseDamageDataRow(int rowIndex);

    GenericEnumDataRow.HouseType getHouseDamageDataHouseType(int houseTypeIndex);
}

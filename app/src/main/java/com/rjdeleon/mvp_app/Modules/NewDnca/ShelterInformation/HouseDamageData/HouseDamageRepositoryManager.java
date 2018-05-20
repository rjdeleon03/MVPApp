package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterCopingData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterGapsData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterHouseDamageData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterHouseDamageDataRow;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterNeedsData;

public interface HouseDamageRepositoryManager {

    void addHouseDamageDataRow(ShelterHouseDamageDataRow houseDamageDataRow);

    void deleteHouseDamageDataRow(int rowIndex);

    ShelterHouseDamageDataRow getHouseDamageDataRow(int rowIndex);

    GenericEnumDataRow.HouseType getHouseDamageDataHouseType(int houseTypeIndex);
}

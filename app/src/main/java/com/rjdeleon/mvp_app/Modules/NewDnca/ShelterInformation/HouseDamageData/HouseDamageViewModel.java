package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageData;
import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoEnumBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoRepositoryManager;

import java.util.List;

public class HouseDamageViewModel extends ShelterInfoEnumBaseViewModel implements HouseDamageRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public HouseDamageViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager, GenericEnumDataRow.HouseType.class);
        mGenericEnumDataRows.addAll(mShelterInfoRepositoryManager.getHouseDamageData().getShelterHouseDamageDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterHouseDamageData houseDamageData = new ShelterHouseDamageData();
        houseDamageData.setShelterHouseDamageDataRows((List<ShelterHouseDamageDataRow>)(Object) mGenericEnumDataRows);
        mShelterInfoRepositoryManager.saveHouseDamageData(houseDamageData);
    }

    /**
     * Adds house damage data row
     * @param houseDamageDataRow
     */
    @Override
    public void addHouseDamageDataRow(ShelterHouseDamageDataRow houseDamageDataRow) {
        super.addAgeGroupDataRow(houseDamageDataRow);
    }

    /**
     * Deletes house damage data row
     * @param rowIndex
     */
    @Override
    public void deleteHouseDamageDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets house damage data row
     * @param rowIndex
     */
    @Override
    public ShelterHouseDamageDataRow getHouseDamageDataRow(int rowIndex) {
        return (ShelterHouseDamageDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets house type based on index
     * @param houseTypeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.HouseType getHouseDamageDataHouseType(int houseTypeIndex) {
        return (GenericEnumDataRow.HouseType) ageGroupList.get(houseTypeIndex);
    }
}

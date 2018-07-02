package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageData;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

import java.util.List;

public class HouseDamageViewModel extends ShelterInfoEnumBaseViewModel implements BaseEnumRepositoryManager<ShelterHouseDamageDataRow, GenericEnumDataRow.HouseType> {

    /**
     * Constructor
     * @param shelterInfoRepositoryManager
     */
    public HouseDamageViewModel(ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(shelterInfoRepositoryManager, GenericEnumDataRow.HouseType.class);
        mGenericEnumDataRows.addAll(mShelterInfoRepositoryManager.getHouseDamageData().getShelterHouseDamageDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterHouseDamageData houseDamageData = new ShelterHouseDamageData((List<ShelterHouseDamageDataRow>)(Object) mGenericEnumDataRows);
        mShelterInfoRepositoryManager.saveHouseDamageData(houseDamageData);
    }

    /**
     * Adds house damage data row
     * @param row
     */
    @Override
    public void addRow(ShelterHouseDamageDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes house damage data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets house damage data row
     * @param rowIndex
     */
    @Override
    public ShelterHouseDamageDataRow getRow(int rowIndex) {
        return (ShelterHouseDamageDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets house type based on index
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.HouseType getEnumType(int typeIndex) {
        return (GenericEnumDataRow.HouseType) ageGroupList.get(typeIndex);
    }
}

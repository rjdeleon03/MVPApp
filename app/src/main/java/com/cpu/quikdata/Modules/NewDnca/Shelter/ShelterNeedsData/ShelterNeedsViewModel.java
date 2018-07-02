package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsData;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

import java.util.List;

public class ShelterNeedsViewModel extends ShelterInfoEnumBaseViewModel implements BaseEnumRepositoryManager<ShelterNeedsDataRow, GenericEnumDataRow.NeedsType> {

    /**
     * Constructor
     * @param shelterInfoRepositoryManager
     */
    public ShelterNeedsViewModel(ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(shelterInfoRepositoryManager, GenericEnumDataRow.NeedsType.class);
        mGenericEnumDataRows.addAll(mShelterInfoRepositoryManager.getShelterNeedsData().getShelterNeedsDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterNeedsData shelterNeedsData = new ShelterNeedsData();
        shelterNeedsData.setShelterNeedsDataRows((List<ShelterNeedsDataRow>)(Object) mGenericEnumDataRows);
        mShelterInfoRepositoryManager.saveShelterNeedsData(shelterNeedsData);
    }

    /**
     * Adds shelter needs data row
     * @param row
     */
    @Override
    public void addRow(ShelterNeedsDataRow row) {
        super.addAgeGroupDataRow(row);
    }
    /**
     * Deletes shelter needs data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Deletes shelter needs data row
     * @param rowIndex
     * @return
     */
    @Override
    public ShelterNeedsDataRow getRow(int rowIndex) {
        return (ShelterNeedsDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets needs type based on index
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.NeedsType getEnumType(int typeIndex) {
        return (GenericEnumDataRow.NeedsType) ageGroupList.get(typeIndex);
    }
}

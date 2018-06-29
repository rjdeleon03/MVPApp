package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsData;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

import java.util.List;

public class ShelterNeedsViewModel extends ShelterInfoEnumBaseViewModel implements ShelterNeedsRepositoryManager {


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
     * @param shelterNeedsDataRow
     */
    @Override
    public void addShelterNeedsDataRow(ShelterNeedsDataRow shelterNeedsDataRow) {
        super.addAgeGroupDataRow(shelterNeedsDataRow);
    }

    /**
     * Deletes shelter needs data row
     * @param rowIndex
     */
    @Override
    public void deleteShelterNeedsDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Deletes shelter needs data row
     * @param rowIndex
     * @return
     */
    @Override
    public ShelterNeedsDataRow getShelterNeedsDataRow(int rowIndex) {
        return (ShelterNeedsDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets needs type based on index
     * @param needsTypeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.NeedsType getShelterNeedsDataType(int needsTypeIndex) {
        return (GenericEnumDataRow.NeedsType) ageGroupList.get(needsTypeIndex);
    }
}

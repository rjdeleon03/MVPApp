package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterNeedsData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterNeedsData;
import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterNeedsDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoEnumBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoRepositoryManager;

import java.util.List;

public class ShelterNeedsViewModel extends ShelterInfoEnumBaseViewModel implements ShelterNeedsRepositoryManager {


    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterNeedsViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager, GenericEnumDataRow.NeedsType.class);
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

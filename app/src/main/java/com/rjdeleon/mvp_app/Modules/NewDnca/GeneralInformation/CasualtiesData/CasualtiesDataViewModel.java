package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.List;

public class CasualtiesDataViewModel extends BaseAgeGroupViewModel implements CasualtiesDataRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public CasualtiesDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        mAgeGroupDataRows.addAll(mNewDncaGenInfoRepositoryManager.getCasualtiesData().getCasualtiesDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        CasualtiesData casualtiesData = new CasualtiesData();
        casualtiesData.setCasualtiesDataRows((List<CasualtiesDataRow>)(Object) mAgeGroupDataRows);
        mNewDncaGenInfoRepositoryManager.saveCasualtiesData(casualtiesData);
    }

    /**
     * Adds casualties data row
     * @param casualtiesDataRow
     */
    @Override
    public void addCasualtiesDataRow(CasualtiesDataRow casualtiesDataRow) {
        super.addAgeGroupDataRow(casualtiesDataRow);
    }

    /**
     * Deletes casualties data row
     * @param rowIndex
     */
    @Override
    public void deleteCasualtiesDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets casualties data row
     * @param rowIndex
     */
    @Override
    public CasualtiesDataRow getCasualtiesDataRow(int rowIndex) {
        return (CasualtiesDataRow) mAgeGroupDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public AgeGroupDataRow.AgeGroup getCasualtiesDataAgeGroup(int ageGroupIndex) {
        return (AgeGroupDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

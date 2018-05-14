package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

public class CasualtiesDataViewModel extends BaseAgeGroupViewModel implements CasualtiesDataRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public CasualtiesDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
        mAgeGroupDataRows.addAll(mNewDncaGenInfoRepositoryManager.getPopulationData().getPopulationDataRows());

    }

    /**
     * Adds casualties data row
     * @param casualtiesDataRow
     */
    @Override
    public void addCasualtiesDataRow(CasualtiesDataRow casualtiesDataRow) {

    }

    /**
     * Deletes casualties data row
     * @param rowIndex
     */
    @Override
    public void deleteCasualtiesDataRow(int rowIndex) {

    }

    /**
     * Gets casualties data row
     * @param rowIndex
     */
    @Override
    public CasualtiesDataRow getCasualtiesDataRow(int rowIndex) {
        return null;
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public AgeGroupDataRow.AgeGroup getCasualtiesDataAgeGroup(int ageGroupIndex) {
        return null;
    }
}

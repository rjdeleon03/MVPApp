package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesData;
import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class CasualtiesDataViewModel extends GenInfoEnumBaseViewModel implements CasualtiesDataRepositoryManager {

    /**
     * Constructor
     * @param genInfoRepositoryManager
     */
    public CasualtiesDataViewModel(GenInfoRepositoryManager genInfoRepositoryManager) {
        super(genInfoRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mGenInfoRepositoryManager.getCasualtiesData().getCasualtiesDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        CasualtiesData casualtiesData = new CasualtiesData();
        casualtiesData.setCasualtiesDataRows((List<CasualtiesDataRow>)(Object) mGenericEnumDataRows);
        mGenInfoRepositoryManager.saveCasualtiesData(casualtiesData);
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
        return (CasualtiesDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getCasualtiesDataAgeGroup(int ageGroupIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

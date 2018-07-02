package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesData;
import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class CasualtiesDataViewModel extends GenInfoEnumBaseViewModel implements BaseEnumRepositoryManager<CasualtiesDataRow, GenericEnumDataRow.AgeGroup> {

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
     * @param row
     */
    @Override
    public void addRow(CasualtiesDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes casualties data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets casualties data row
     * @param rowIndex
     */
    @Override
    public CasualtiesDataRow getRow(int rowIndex) {
        return (CasualtiesDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getEnumType(int typeIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(typeIndex);
    }
}

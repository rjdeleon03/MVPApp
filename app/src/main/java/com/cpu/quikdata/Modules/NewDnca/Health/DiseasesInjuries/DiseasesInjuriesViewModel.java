package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesData;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;

import java.util.List;

public class DiseasesInjuriesViewModel extends HealthEnumBaseViewModel implements BaseEnumRepositoryManager<DiseasesInjuriesDataRow, GenericEnumDataRow.AgeGroup> {

    /**
     * Constructor
     * @param healthRepositoryManager
     */
    public DiseasesInjuriesViewModel(HealthRepositoryManager healthRepositoryManager) {
        super(healthRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mHealthRepositoryManager.getDiseasesInjuriesData().getDiseasesInjuriesDataRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        DiseasesInjuriesData diseasesInjuriesData = new DiseasesInjuriesData((List<DiseasesInjuriesDataRow>)(Object) mGenericEnumDataRows);
        mHealthRepositoryManager.saveDiseasesInjuriesData(diseasesInjuriesData);
    }

    /**
     * Adds diseases and injuries data row
     * @param row
     */
    @Override
    public void addRow(DiseasesInjuriesDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes diseases and injuries data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets diseases and injuries data row
     * @param rowIndex
     * @return
     */
    @Override
    public DiseasesInjuriesDataRow getRow(int rowIndex) {
        return (DiseasesInjuriesDataRow) mGenericEnumDataRows.get(rowIndex);
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

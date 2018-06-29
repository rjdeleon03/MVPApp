package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesData;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;

import java.util.List;

import javax.annotation.Nullable;

public class DiseasesInjuriesViewModel extends HealthEnumBaseViewModel implements DiseasesInjuriesRepositoryManager {

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
     * @param diseasesInjuriesDataRow
     */
    @Override
    public void addDiseasesInjuriesDataRow(DiseasesInjuriesDataRow diseasesInjuriesDataRow) {
        super.addAgeGroupDataRow(diseasesInjuriesDataRow);
    }

    /**
     * Deletes diseases and injuries data row
     * @param rowIndex
     */
    @Override
    public void deleteDiseasesInjuriesDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets diseases and injuries data row
     * @param rowIndex
     * @return
     */
    @Override
    public DiseasesInjuriesDataRow getDiseasesInjuriesDataRow(int rowIndex) {
        return (DiseasesInjuriesDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getDiseasesInjuriesAgeGroup(int ageGroupIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

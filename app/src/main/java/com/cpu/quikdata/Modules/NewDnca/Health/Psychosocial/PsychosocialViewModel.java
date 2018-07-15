package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.PsychosocialData;
import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;

import java.util.List;

public class PsychosocialViewModel extends HealthEnumBaseViewModel implements BaseEnumRepositoryManager<PsychosocialDataRow, GenericEnumDataRow.AgeGroup> {

    /**
     * Constructor
     * @param healthRepositoryManager
     */
    public PsychosocialViewModel(HealthRepositoryManager healthRepositoryManager) {
        super(healthRepositoryManager, GenericEnumDataRow.AgeGroup.class);
        mGenericEnumDataRows.addAll(mHealthRepositoryManager.getPsychosocialData().getPsychosocialDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        PsychosocialData psychosocialData = new PsychosocialData((List<PsychosocialDataRow>)(Object) mGenericEnumDataRows);
        mHealthRepositoryManager.savePsychosocialData(psychosocialData);
    }

    /**
     * Adds psychosocial data row
     * @param row
     */
    @Override
    public void addRow(PsychosocialDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes psychosocial data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets psychosocial data row
     * @param rowIndex
     * @return
     */
    @Override
    public PsychosocialDataRow getRow(int rowIndex) {
        return (PsychosocialDataRow) mGenericEnumDataRows.get(rowIndex);
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

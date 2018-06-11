package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.PsychosocialData;
import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;

import java.util.List;

public class PsychosocialViewModel extends HealthEnumBaseViewModel implements PsychosocialRepositoryManager {

    /**
     * Constructor
     *
     * @param context
     * @param healthRepositoryManager
     */
    public PsychosocialViewModel(Context context, HealthRepositoryManager healthRepositoryManager) {
        super(context, healthRepositoryManager, GenericEnumDataRow.AgeGroup.class);
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
     * @param psychosocialDataRow
     */
    @Override
    public void addPsychosocialDataRow(PsychosocialDataRow psychosocialDataRow) {
        super.addAgeGroupDataRow(psychosocialDataRow);
    }

    /**
     * Deletes psychosocial data row
     * @param rowIndex
     */
    @Override
    public void deletePsychosocialDataRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets psychosocial data row
     * @param rowIndex
     * @return
     */
    @Override
    public PsychosocialDataRow getPsychosocialDataRow(int rowIndex) {
        return (PsychosocialDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.AgeGroup getPsychosocialDataAgeGroup(int ageGroupIndex) {
        return (GenericEnumDataRow.AgeGroup) ageGroupList.get(ageGroupIndex);
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class InfrastructureDamageViewModel extends BaseAgeGroupViewModel implements InfrastructureDamageRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public InfrastructureDamageViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager, AgeGroupDataRow.InfraType.class);
        mAgeGroupDataRows.addAll(mNewDncaGenInfoRepositoryManager.getInfrastructureDamageData().getInfrastructureDamageDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        InfrastructureDamageData infrastructureDamageData = new InfrastructureDamageData();
        infrastructureDamageData.setInfrastructureDamageDataRows((List<InfrastructureDamageDataRow>)(Object) mAgeGroupDataRows);
        mNewDncaGenInfoRepositoryManager.saveInfrastructureDamageData(infrastructureDamageData);
    }
    /**
     * Adds infrastructure damage data row
     * @param infrastructureDamageDataRow
     */
    @Override
    public void addInfrastructureDamageRow(InfrastructureDamageDataRow infrastructureDamageDataRow) {
        super.addAgeGroupDataRow(infrastructureDamageDataRow);
    }
    /**
     * Deletes infrastructure damage data row
     * @param rowIndex
     */
    @Override
    public void deleteInfrastructureDamageRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets infrastructure damage data row
     * @param rowIndex
     */
    @Override
    public InfrastructureDamageDataRow getInfrastructureDamageRow(int rowIndex) {
        return (InfrastructureDamageDataRow) mAgeGroupDataRows.get(rowIndex);
    }

    /**
     * Gets infrasture type based on index
     * @param infraTypeIndex
     * @return
     */
    @Override
    public AgeGroupDataRow.InfraType getInfrastructureDamageType(int infraTypeIndex) {
        return (AgeGroupDataRow.InfraType) ageGroupList.get(infraTypeIndex);
    }
}

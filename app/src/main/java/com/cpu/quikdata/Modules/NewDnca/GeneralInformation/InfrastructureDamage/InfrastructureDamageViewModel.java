package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageData;
import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class InfrastructureDamageViewModel extends GenInfoEnumBaseViewModel implements InfrastructureDamageRepositoryManager {

    /**
     * Constructor
     * @param genInfoRepositoryManager
     */
    public InfrastructureDamageViewModel(GenInfoRepositoryManager genInfoRepositoryManager) {
        super(genInfoRepositoryManager, GenericEnumDataRow.InfraType.class);
        mGenericEnumDataRows.addAll(mGenInfoRepositoryManager.getInfrastructureDamageData().getInfrastructureDamageDataRows());
        super.updateAgeGroupList();
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        InfrastructureDamageData infrastructureDamageData = new InfrastructureDamageData();
        infrastructureDamageData.setInfrastructureDamageDataRows((List<InfrastructureDamageDataRow>)(Object) mGenericEnumDataRows);
        mGenInfoRepositoryManager.saveInfrastructureDamageData(infrastructureDamageData);
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
        return (InfrastructureDamageDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets infrasture type based on index
     * @param infraTypeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.InfraType getInfrastructureDamageType(int infraTypeIndex) {
        return (GenericEnumDataRow.InfraType) ageGroupList.get(infraTypeIndex);
    }
}

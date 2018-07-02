package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageData;
import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoEnumBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.List;

public class InfrastructureDamageViewModel extends GenInfoEnumBaseViewModel implements BaseEnumRepositoryManager<InfrastructureDamageDataRow, GenericEnumDataRow.InfraType> {

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
     * @param row
     */
    @Override
    public void addRow(InfrastructureDamageDataRow row) {
        super.addAgeGroupDataRow(row);
    }

    /**
     * Deletes infrastructure damage data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    /**
     * Gets infrastructure damage data row
     * @param rowIndex
     */
    @Override
    public InfrastructureDamageDataRow getRow(int rowIndex) {
        return (InfrastructureDamageDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    /**
     * Gets infrastructure type based on index
     * @param typeIndex
     * @return
     */
    @Override
    public GenericEnumDataRow.InfraType getEnumType(int typeIndex) {
        return (GenericEnumDataRow.InfraType) ageGroupList.get(typeIndex);
    }
}

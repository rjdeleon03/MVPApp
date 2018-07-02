package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import com.cpu.quikdata.Models.Generics.AssistanceData;
import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import java.util.List;

public class AssistanceDataViewModel extends BaseEnumViewModel implements BaseEnumRepositoryManager<AssistanceDataRow, GenericEnumDataRow.Assistance> {

    private AssistanceDataContainer mAssistanceDataContainer;

    /**
     * Constructor
     */
    public AssistanceDataViewModel(AssistanceDataContainer assistanceDataContainer) {
        super(GenericEnumDataRow.Assistance.class);
        mAssistanceDataContainer = assistanceDataContainer;
        mGenericEnumDataRows.addAll(mAssistanceDataContainer.getAssistanceData().getAssistanceDataRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        AssistanceData assistanceData = new AssistanceData();
        assistanceData.setAssistanceDataRows((List<AssistanceDataRow>)(Object) mGenericEnumDataRows);
        mAssistanceDataContainer.saveAssistanceData(assistanceData);
    }

    /**
     * Adds assistance data row
     * @param row
     */
    @Override
    // TODO: Add subclassed interface for non-type specific rows
    public void addRow(AssistanceDataRow row) {
        mGenericEnumDataRows.add(row);
    }

    public void addRow(AssistanceDataRow row, int rowIndex) {
        if (rowIndex == -1) {
            mGenericEnumDataRows.add(row);
        } else {
            mGenericEnumDataRows.set(rowIndex, row);
        }
    }

    /**
     * Deletes assistance data row
     * @param rowIndex
     */
    @Override
    public void deleteRow(int rowIndex) {
        mGenericEnumDataRows.remove(rowIndex);
    }

    /**
     * Gets assistance data row
     * @param rowIndex
     * @return
     */
    @Override
    public AssistanceDataRow getRow(int rowIndex) {
        return (AssistanceDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    @Override
    public GenericEnumDataRow.Assistance getEnumType(int typeIndex) {
        return null;
    }
}

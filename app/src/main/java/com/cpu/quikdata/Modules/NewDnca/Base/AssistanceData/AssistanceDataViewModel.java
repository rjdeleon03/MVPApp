package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.AssistanceData;
import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import java.util.List;

public class AssistanceDataViewModel extends BaseEnumViewModel implements AssistanceDataRepositoryManager {

    private AssistanceDataContainer mAssistanceDataContainer;

    /**
     * Constructor
     */
    public AssistanceDataViewModel(AssistanceDataContainer assistanceDataContainer) {
        super(null);
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
     * @param assistanceDataRow
     */
    @Override
    public void addAssistanceDataRow(AssistanceDataRow assistanceDataRow, int rowIndex) {
        if (rowIndex == -1) {
            mGenericEnumDataRows.add(assistanceDataRow);
        } else {
            mGenericEnumDataRows.set(rowIndex, assistanceDataRow);
        }
    }

    /**
     * Deletes assistance data row
     * @param rowIndex
     */
    @Override
    public void deleteAssistanceDataRow(int rowIndex) {
        mGenericEnumDataRows.remove(rowIndex);
    }

    /**
     * Gets assistance data row
     * @param rowIndex
     * @return
     */
    @Override
    public AssistanceDataRow getAssistanceDataRow(int rowIndex) {
        return (AssistanceDataRow) mGenericEnumDataRows.get(rowIndex);
    }
}

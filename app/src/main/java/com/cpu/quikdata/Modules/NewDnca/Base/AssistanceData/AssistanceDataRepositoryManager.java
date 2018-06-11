package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;

public interface AssistanceDataRepositoryManager {

    void addAssistanceDataRow(AssistanceDataRow assistanceDataRow, int rowIndex);

    void deleteAssistanceDataRow(int rowIndex);

    AssistanceDataRow getAssistanceDataRow(int rowIndex);
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceDataRow;

public interface AssistanceDataRepositoryManager {

    void addAssistanceDataRow(AssistanceDataRow assistanceDataRow, int rowIndex);

    void deleteAssistanceDataRow(int rowIndex);

    AssistanceDataRow getAssistanceDataRow(int rowIndex);
}

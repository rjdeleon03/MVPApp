package com.rjdeleon.mvp_app.Models.Generics;

import java.util.ArrayList;
import java.util.List;

public class AssistanceData {

    public List<AssistanceDataRow> assistanceDataRows;

    public AssistanceData(List<AssistanceDataRow> assistanceDataRows) {
        this.assistanceDataRows = assistanceDataRows;
    }

    public AssistanceData() {
        this.assistanceDataRows = new ArrayList<>();
    }

    public List<AssistanceDataRow> getAssistanceDataRows() {
        return assistanceDataRows;
    }

    public void setAssistanceDataRows(List<AssistanceDataRow> assistanceDataRows) {
        this.assistanceDataRows = assistanceDataRows;
    }
}

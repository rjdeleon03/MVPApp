package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import com.cpu.quikdata.Models.Generics.AssistanceData;

public interface AssistanceDataContainer {

    AssistanceData getAssistanceData();

    void saveAssistanceData(AssistanceData assistanceData);
}

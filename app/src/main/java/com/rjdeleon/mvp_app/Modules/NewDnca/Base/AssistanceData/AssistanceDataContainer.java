package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData;

import com.rjdeleon.mvp_app.Models.Generics.AssistanceData;

public interface AssistanceDataContainer {

    AssistanceData getAssistanceData();

    void saveAssistanceData(AssistanceData assistanceData);
}

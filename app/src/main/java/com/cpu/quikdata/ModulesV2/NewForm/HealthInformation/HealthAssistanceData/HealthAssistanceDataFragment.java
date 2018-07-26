package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthAssistanceData;

import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData.AssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class HealthAssistanceDataFragment extends AssistanceDataFragment {

    public HealthAssistanceDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH_ASSISTANCE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static HealthAssistanceDataFragment newInstance() {

        return new HealthAssistanceDataFragment();
    }
}

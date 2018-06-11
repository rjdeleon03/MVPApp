package com.cpu.quikdata.Modules.NewDnca.Health.HealthAssistanceData;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.cpu.quikdata.AppConstants.HealthComponent.HEALTH_ASSISTANCE;

public class HealthAssistanceDataFragment extends AssistanceDataFragment {

    public static HealthAssistanceDataFragment newInstance() {
        return new HealthAssistanceDataFragment();
    }

    public HealthAssistanceDataFragment() {
        setFragmentTag(HEALTH_ASSISTANCE.toString());
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthAssistanceData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_ASSISTANCE;

public class HealthAssistanceDataFragment extends AssistanceDataFragment {

    public static HealthAssistanceDataFragment newInstance() {
        return new HealthAssistanceDataFragment();
    }

    public HealthAssistanceDataFragment() {
        setFragmentTag(HEALTH_ASSISTANCE.toString());
    }
}

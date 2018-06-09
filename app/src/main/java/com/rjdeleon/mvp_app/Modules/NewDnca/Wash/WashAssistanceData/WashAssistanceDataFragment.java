package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashAssistanceData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_ASSISTANCE;

public class WashAssistanceDataFragment extends AssistanceDataFragment {

    public static WashAssistanceDataFragment newInstance() {
        return new WashAssistanceDataFragment();
    }

    public WashAssistanceDataFragment() {
        setFragmentTag(WASH_ASSISTANCE.toString());
    }
}

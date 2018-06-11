package com.cpu.quikdata.Modules.NewDnca.Wash.WashAssistanceData;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.cpu.quikdata.AppConstants.WashComponent.WASH_ASSISTANCE;

public class WashAssistanceDataFragment extends AssistanceDataFragment {

    public static WashAssistanceDataFragment newInstance() {
        return new WashAssistanceDataFragment();
    }

    public WashAssistanceDataFragment() {
        setFragmentTag(WASH_ASSISTANCE.toString());
    }
}

package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashAssistanceData;

import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class WashAssistanceDataFragment extends AssistanceDataFragment {

    public WashAssistanceDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.WASH_ASSISTANCE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static WashAssistanceDataFragment newInstance() {

        return new WashAssistanceDataFragment();
    }
}

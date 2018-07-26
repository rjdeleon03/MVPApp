package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsAssistanceData;

import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class LivelihoodsAssistanceDataFragment extends AssistanceDataFragment {

    public LivelihoodsAssistanceDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_ASSISTANCE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static LivelihoodsAssistanceDataFragment newInstance() {

        return new LivelihoodsAssistanceDataFragment();
    }
}

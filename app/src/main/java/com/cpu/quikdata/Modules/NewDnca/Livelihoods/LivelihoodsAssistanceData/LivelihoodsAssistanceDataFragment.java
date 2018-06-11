package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsAssistanceData;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.cpu.quikdata.AppConstants.LivelihoodsComponent.LIVELIHOODS_ASSISTANCE;

public class LivelihoodsAssistanceDataFragment extends AssistanceDataFragment {

    public static LivelihoodsAssistanceDataFragment newInstance() {
        return new LivelihoodsAssistanceDataFragment();
    }

    public LivelihoodsAssistanceDataFragment() {
        setFragmentTag(LIVELIHOODS_ASSISTANCE.toString());
    }
}

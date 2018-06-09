package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsAssistanceData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_ASSISTANCE;

public class LivelihoodsAssistanceDataFragment extends AssistanceDataFragment {

    public static LivelihoodsAssistanceDataFragment newInstance() {
        return new LivelihoodsAssistanceDataFragment();
    }

    public LivelihoodsAssistanceDataFragment() {
        setFragmentTag(LIVELIHOODS_ASSISTANCE.toString());
    }
}

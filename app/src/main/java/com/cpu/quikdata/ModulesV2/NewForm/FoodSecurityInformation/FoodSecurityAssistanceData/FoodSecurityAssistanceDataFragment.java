package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityAssistanceData;

import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class FoodSecurityAssistanceDataFragment extends AssistanceDataFragment {

    public FoodSecurityAssistanceDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.FOOD_SECURITY_ASSISTANCE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FoodSecurityAssistanceDataFragment newInstance() {

        return new FoodSecurityAssistanceDataFragment();
    }
}

package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodAssistanceData;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_ASSISTANCE;

public class FoodAssistanceDataFragment extends AssistanceDataFragment {

    public static FoodAssistanceDataFragment newInstance() {
        return new FoodAssistanceDataFragment();
    }

    public FoodAssistanceDataFragment() {
        setFragmentTag(FOOD_ASSISTANCE.toString());
    }
}

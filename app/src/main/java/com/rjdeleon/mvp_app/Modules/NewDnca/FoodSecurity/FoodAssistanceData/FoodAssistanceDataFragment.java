package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodAssistanceData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.rjdeleon.mvp_app.AppConstants.FoodSecurityComponent.FOOD_ASSISTANCE;

public class FoodAssistanceDataFragment extends AssistanceDataFragment {

    public static FoodAssistanceDataFragment newInstance() {
        return new FoodAssistanceDataFragment();
    }

    public FoodAssistanceDataFragment() {
        setFragmentTag(FOOD_ASSISTANCE.toString());
    }
}

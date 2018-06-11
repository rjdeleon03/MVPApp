package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodImpactData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_IMPACT;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodImpactDataFragment extends BaseQuestionFragment {

    public static FoodImpactDataFragment newInstance() {
        return new FoodImpactDataFragment();
    }

    public FoodImpactDataFragment() {
        setFragmentTag(FOOD_IMPACT.toString());
    }
}

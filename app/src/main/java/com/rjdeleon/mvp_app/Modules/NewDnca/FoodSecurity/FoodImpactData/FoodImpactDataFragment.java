package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.FoodSecurityComponent.FOOD_IMPACT;

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

package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodNeedsData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.FoodSecurityComponent.FOOD_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodNeedsDataFragment extends BaseQuestionFragment {

    public static FoodNeedsDataFragment newInstance() {
        return new FoodNeedsDataFragment();
    }

    public FoodNeedsDataFragment() {
        setFragmentTag(FOOD_NEEDS.toString());
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodGapsData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.FoodSecurityComponent.FOOD_GAPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodGapsDataFragment extends BaseQuestionFragment {

    public static FoodGapsDataFragment newInstance() {
        return new FoodGapsDataFragment();
    }

    public FoodGapsDataFragment() {
        setFragmentTag(FOOD_GAPS.toString());
    }
}

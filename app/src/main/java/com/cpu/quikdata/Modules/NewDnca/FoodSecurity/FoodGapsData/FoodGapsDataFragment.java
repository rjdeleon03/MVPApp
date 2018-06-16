package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodGapsData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_GAPS;

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

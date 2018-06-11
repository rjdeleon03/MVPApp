package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodNeedsData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_NEEDS;

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

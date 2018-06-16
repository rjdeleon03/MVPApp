package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodCopingData;


import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_COPING;

public class FoodCopingDataFragment extends BaseQuestionFragment {

    public static FoodCopingDataFragment newInstance() {
        return new FoodCopingDataFragment();
    }

    public FoodCopingDataFragment() {
        setFragmentTag(FOOD_COPING.toString());
    }
}

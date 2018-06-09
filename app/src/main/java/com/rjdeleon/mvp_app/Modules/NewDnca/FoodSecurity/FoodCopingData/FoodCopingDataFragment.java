package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodCopingData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataFragment;

import static com.rjdeleon.mvp_app.AppConstants.FoodSecurityComponent.FOOD_COPING;

public class FoodCopingDataFragment extends GenericCopingDataFragment {

    public static FoodCopingDataFragment newInstance() {
        return new FoodCopingDataFragment();
    }

    public FoodCopingDataFragment() {
        setFragmentTag(FOOD_COPING.toString());
    }
}

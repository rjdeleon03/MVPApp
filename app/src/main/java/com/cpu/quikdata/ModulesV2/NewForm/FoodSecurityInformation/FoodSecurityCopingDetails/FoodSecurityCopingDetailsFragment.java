package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityCopingDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class FoodSecurityCopingDetailsFragment extends TemplateQuestionFragment {

    public FoodSecurityCopingDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.FOOD_SECURITY_COPING.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FoodSecurityCopingDetailsFragment newInstance() {

        return new FoodSecurityCopingDetailsFragment();
    }
}

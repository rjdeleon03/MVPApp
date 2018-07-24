package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityGapsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class FoodSecurityGapsDetailsFragment extends TemplateQuestionFragment {

    public FoodSecurityGapsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.FOOD_SECURITY_GAPS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FoodSecurityGapsDetailsFragment newInstance() {

        return new FoodSecurityGapsDetailsFragment();
    }
}

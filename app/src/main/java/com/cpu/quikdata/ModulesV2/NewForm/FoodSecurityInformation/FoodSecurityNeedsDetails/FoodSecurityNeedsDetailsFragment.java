package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityNeedsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class FoodSecurityNeedsDetailsFragment extends TemplateQuestionFragment {

    public FoodSecurityNeedsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.FOOD_SECURITY_NEEDS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FoodSecurityNeedsDetailsFragment newInstance() {

        return new FoodSecurityNeedsDetailsFragment();
    }
}

package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.ImpactDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class ImpactDetailsFragment extends TemplateQuestionFragment {

    public ImpactDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ImpactDetailsFragment newInstance() {

        return new ImpactDetailsFragment();
    }
}

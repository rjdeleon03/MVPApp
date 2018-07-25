package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class WashConditionsDetailsFragment extends TemplateQuestionFragment {

    public WashConditionsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.WASH_CONDITIONS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static WashConditionsDetailsFragment newInstance() {

        return new WashConditionsDetailsFragment();
    }
}

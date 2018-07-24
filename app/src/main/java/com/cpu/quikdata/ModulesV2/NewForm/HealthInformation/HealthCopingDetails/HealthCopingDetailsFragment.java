package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthCopingDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class HealthCopingDetailsFragment extends TemplateQuestionFragment {

    public HealthCopingDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH_COPING.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static HealthCopingDetailsFragment newInstance() {

        return new HealthCopingDetailsFragment();
    }
}

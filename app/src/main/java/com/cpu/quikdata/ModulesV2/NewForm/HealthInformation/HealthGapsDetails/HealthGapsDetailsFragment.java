package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthGapsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class HealthGapsDetailsFragment extends TemplateQuestionFragment {

    public HealthGapsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH_GAPS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static HealthGapsDetailsFragment newInstance() {

        return new HealthGapsDetailsFragment();
    }
}

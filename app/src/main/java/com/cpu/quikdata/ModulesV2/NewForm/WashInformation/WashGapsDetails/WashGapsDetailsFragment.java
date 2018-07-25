package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashGapsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class WashGapsDetailsFragment extends TemplateQuestionFragment {

    public WashGapsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.WASH_GAPS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static WashGapsDetailsFragment newInstance() {

        return new WashGapsDetailsFragment();
    }
}

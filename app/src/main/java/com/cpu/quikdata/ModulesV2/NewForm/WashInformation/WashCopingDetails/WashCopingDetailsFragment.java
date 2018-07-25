package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashCopingDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class WashCopingDetailsFragment extends TemplateQuestionFragment {

    public WashCopingDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.WASH_COPING.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static WashCopingDetailsFragment newInstance() {

        return new WashCopingDetailsFragment();
    }
}

package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class CalamityDetailsFragment extends TemplateQuestionFragment {

    public CalamityDetailsFragment() {
        // Required empty public constructor\
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static CalamityDetailsFragment newInstance() {

        return new CalamityDetailsFragment();
    }
}

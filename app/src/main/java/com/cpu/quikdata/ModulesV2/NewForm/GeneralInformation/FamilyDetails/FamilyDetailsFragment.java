package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class FamilyDetailsFragment extends TemplateQuestionFragment {

    public FamilyDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_FAMILY.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FamilyDetailsFragment newInstance() {

        return new FamilyDetailsFragment();
    }
}

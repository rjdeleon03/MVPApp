package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class ShelterGapsDetailsFragment extends TemplateQuestionFragment {

    public ShelterGapsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_INFO_GAPS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterGapsDetailsFragment newInstance() {

        return new ShelterGapsDetailsFragment();
    }
}

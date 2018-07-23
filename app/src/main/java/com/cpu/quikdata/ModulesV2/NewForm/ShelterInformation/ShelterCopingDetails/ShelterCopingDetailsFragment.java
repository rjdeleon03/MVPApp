package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class ShelterCopingDetailsFragment extends TemplateQuestionFragment {

    public ShelterCopingDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_INFO_COPING.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterCopingDetailsFragment newInstance() {

        return new ShelterCopingDetailsFragment();
    }
}

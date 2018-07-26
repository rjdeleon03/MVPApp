package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterAssistanceData;

import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class ShelterAssistanceDataFragment extends AssistanceDataFragment {

    public ShelterAssistanceDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_ASSISTANCE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterAssistanceDataFragment newInstance() {

        return new ShelterAssistanceDataFragment();
    }
}

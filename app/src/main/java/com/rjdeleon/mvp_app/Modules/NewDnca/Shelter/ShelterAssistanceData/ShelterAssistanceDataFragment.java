package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterAssistanceData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_ASSISTANCE;

public class ShelterAssistanceDataFragment extends AssistanceDataFragment {

    public static ShelterAssistanceDataFragment newInstance() {
        return new ShelterAssistanceDataFragment();
    }

    public ShelterAssistanceDataFragment() {
        setFragmentTag(SHELTER_ASSISTANCE.toString());
    }
}

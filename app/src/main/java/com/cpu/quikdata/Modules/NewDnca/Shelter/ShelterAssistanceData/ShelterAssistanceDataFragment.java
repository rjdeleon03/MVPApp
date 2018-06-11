package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterAssistanceData;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;

import static com.cpu.quikdata.AppConstants.ShelterInfoComponent.SHELTER_ASSISTANCE;

public class ShelterAssistanceDataFragment extends AssistanceDataFragment {

    public static ShelterAssistanceDataFragment newInstance() {
        return new ShelterAssistanceDataFragment();
    }

    public ShelterAssistanceDataFragment() {
        setFragmentTag(SHELTER_ASSISTANCE.toString());
    }
}

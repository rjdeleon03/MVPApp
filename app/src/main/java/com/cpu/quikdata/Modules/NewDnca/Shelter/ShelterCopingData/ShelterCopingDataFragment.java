package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.ShelterInfoComponent.SHELTER_COPING;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterCopingDataFragment extends BaseQuestionFragment {

    public static ShelterCopingDataFragment newInstance() {
        return new ShelterCopingDataFragment();
    }

    public ShelterCopingDataFragment() {
        setFragmentTag(SHELTER_COPING.toString());
    }
}

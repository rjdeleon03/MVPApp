package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.ShelterInfoComponent.SHELTER_GAPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterGapsDataFragment extends BaseQuestionFragment {

    public ShelterGapsDataFragment() {
        setFragmentTag(SHELTER_GAPS.toString());
    }

    public static ShelterGapsDataFragment newInstance() {
        return new ShelterGapsDataFragment();
    }
}

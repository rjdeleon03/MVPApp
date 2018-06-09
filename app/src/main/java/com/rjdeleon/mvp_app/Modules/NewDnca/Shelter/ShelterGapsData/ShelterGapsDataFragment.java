package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterGapsData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_GAPS;

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

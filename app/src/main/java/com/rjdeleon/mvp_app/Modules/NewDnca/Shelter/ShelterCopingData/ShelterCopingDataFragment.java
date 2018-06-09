package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterCopingData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_COPING;

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

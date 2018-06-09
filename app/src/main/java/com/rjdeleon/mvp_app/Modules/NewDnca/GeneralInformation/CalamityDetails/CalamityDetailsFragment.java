package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.GenInfoComponent.GEN_INFO_CALAMITY;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalamityDetailsFragment extends BaseQuestionFragment {

    public static CalamityDetailsFragment newInstance() {
        return new CalamityDetailsFragment();
    }

    public CalamityDetailsFragment() {
        setFragmentTag(GEN_INFO_CALAMITY.toString());
    }

}

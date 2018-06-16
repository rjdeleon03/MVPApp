package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CalamityDetails;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_CALAMITY;


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

package com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FORM_GEN_FORM_DETAILS;

public class GenFormDetailsFragment extends BaseQuestionFragment {

    public static GenFormDetailsFragment newInstance() {
        return new GenFormDetailsFragment();
    }

    public GenFormDetailsFragment() {
        setFragmentTag(FORM_GEN_FORM_DETAILS.toString());
    }
}

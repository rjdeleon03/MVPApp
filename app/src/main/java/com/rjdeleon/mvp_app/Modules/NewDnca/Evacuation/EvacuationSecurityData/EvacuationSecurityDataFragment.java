package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSecurityData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_FACILITIES;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_SECURITY;

public class EvacuationSecurityDataFragment extends BaseQuestionFragment {

    public static EvacuationSecurityDataFragment newInstance() {
        return new EvacuationSecurityDataFragment();
    }

    public EvacuationSecurityDataFragment() {
        setFragmentTag(EVACUATION_SECURITY.toString());
    }
}

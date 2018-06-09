package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationWashData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_SITE;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_WASH;

public class EvacuationWashDataFragment extends BaseQuestionFragment {

    public static EvacuationWashDataFragment newInstance() {
        return new EvacuationWashDataFragment();
    }

    public EvacuationWashDataFragment() {
        setFragmentTag(EVACUATION_WASH.toString());
    }
}

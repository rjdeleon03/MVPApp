package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationCopingData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_COPING;
import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_CONDITIONS;

public class EvacuationCopingDataFragment extends BaseQuestionFragment {

    public static EvacuationCopingDataFragment newInstance() {
        return new EvacuationCopingDataFragment();
    }

    public EvacuationCopingDataFragment() {
        setFragmentTag(EVACUATION_COPING.toString());

    }
}

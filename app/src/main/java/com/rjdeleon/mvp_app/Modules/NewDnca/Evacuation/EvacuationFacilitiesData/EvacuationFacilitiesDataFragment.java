package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationFacilitiesData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_FACILITIES;
import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_CONDITIONS;

public class EvacuationFacilitiesDataFragment extends BaseQuestionFragment {

    public static EvacuationFacilitiesDataFragment newInstance() {
        return new EvacuationFacilitiesDataFragment();
    }

    public EvacuationFacilitiesDataFragment() {
        setFragmentTag(EVACUATION_FACILITIES.toString());

    }
}

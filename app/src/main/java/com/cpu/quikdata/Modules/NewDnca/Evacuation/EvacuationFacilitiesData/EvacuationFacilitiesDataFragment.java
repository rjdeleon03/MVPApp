package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationFacilitiesData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.EvacuationComponent.EVACUATION_FACILITIES;
import static com.cpu.quikdata.AppConstants.WashComponent.WASH_CONDITIONS;

public class EvacuationFacilitiesDataFragment extends BaseQuestionFragment {

    public static EvacuationFacilitiesDataFragment newInstance() {
        return new EvacuationFacilitiesDataFragment();
    }

    public EvacuationFacilitiesDataFragment() {
        setFragmentTag(EVACUATION_FACILITIES.toString());

    }
}

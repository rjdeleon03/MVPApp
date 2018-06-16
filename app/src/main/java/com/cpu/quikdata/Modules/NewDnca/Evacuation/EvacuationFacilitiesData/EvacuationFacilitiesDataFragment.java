package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationFacilitiesData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_FACILITIES;

public class EvacuationFacilitiesDataFragment extends BaseQuestionFragment {

    public static EvacuationFacilitiesDataFragment newInstance() {
        return new EvacuationFacilitiesDataFragment();
    }

    public EvacuationFacilitiesDataFragment() {
        setFragmentTag(EVACUATION_FACILITIES.toString());

    }
}

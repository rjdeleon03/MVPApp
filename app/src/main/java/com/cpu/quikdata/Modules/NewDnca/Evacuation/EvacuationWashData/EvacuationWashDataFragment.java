package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationWashData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.EvacuationComponent.EVACUATION_SITE;
import static com.cpu.quikdata.AppConstants.EvacuationComponent.EVACUATION_WASH;

public class EvacuationWashDataFragment extends BaseQuestionFragment {

    public static EvacuationWashDataFragment newInstance() {
        return new EvacuationWashDataFragment();
    }

    public EvacuationWashDataFragment() {
        setFragmentTag(EVACUATION_WASH.toString());
    }
}
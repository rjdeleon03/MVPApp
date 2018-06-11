package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationCopingData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.EvacuationComponent.EVACUATION_COPING;
import static com.cpu.quikdata.AppConstants.WashComponent.WASH_CONDITIONS;

public class EvacuationCopingDataFragment extends BaseQuestionFragment {

    public static EvacuationCopingDataFragment newInstance() {
        return new EvacuationCopingDataFragment();
    }

    public EvacuationCopingDataFragment() {
        setFragmentTag(EVACUATION_COPING.toString());

    }
}

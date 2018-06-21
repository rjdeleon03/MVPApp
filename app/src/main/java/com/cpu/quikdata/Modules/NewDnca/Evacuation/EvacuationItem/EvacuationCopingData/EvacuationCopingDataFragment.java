package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_COPING;

public class EvacuationCopingDataFragment extends BaseQuestionFragment {

    public static EvacuationCopingDataFragment newInstance() {
        return new EvacuationCopingDataFragment();
    }

    public EvacuationCopingDataFragment() {
        setFragmentTag(EVACUATION_COPING.toString());
    }
}

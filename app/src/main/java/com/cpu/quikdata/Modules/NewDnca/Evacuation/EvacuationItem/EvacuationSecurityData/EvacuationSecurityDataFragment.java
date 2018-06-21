package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_SECURITY;

public class EvacuationSecurityDataFragment extends BaseQuestionFragment {

    public static EvacuationSecurityDataFragment newInstance() {
        return new EvacuationSecurityDataFragment();
    }

    public EvacuationSecurityDataFragment() {
        setFragmentTag(EVACUATION_SECURITY.toString());
    }
}

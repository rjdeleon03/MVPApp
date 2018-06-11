package com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.WashComponent.WASH_COPING;

public class WashCopingDataFragment extends BaseQuestionFragment {

    public static WashCopingDataFragment newInstance() {
        return new WashCopingDataFragment();
    }

    public WashCopingDataFragment() {
        setFragmentTag(WASH_COPING.toString());
    }
}

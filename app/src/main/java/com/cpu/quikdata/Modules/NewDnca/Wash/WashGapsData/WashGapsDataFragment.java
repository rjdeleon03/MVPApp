package com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.WashComponent.WASH_COPING;
import static com.cpu.quikdata.AppConstants.WashComponent.WASH_GAPS;

public class WashGapsDataFragment extends BaseQuestionFragment {

    public static WashGapsDataFragment newInstance() {
        return new WashGapsDataFragment();
    }

    public WashGapsDataFragment() {
        setFragmentTag(WASH_GAPS.toString());

    }
}

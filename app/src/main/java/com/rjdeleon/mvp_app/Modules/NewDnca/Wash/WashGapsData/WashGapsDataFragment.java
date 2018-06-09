package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashGapsData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_COPING;
import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_GAPS;

public class WashGapsDataFragment extends BaseQuestionFragment {

    public static WashGapsDataFragment newInstance() {
        return new WashGapsDataFragment();
    }

    public WashGapsDataFragment() {
        setFragmentTag(WASH_GAPS.toString());

    }
}

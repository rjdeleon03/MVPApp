package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashCopingData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_COPING;

public class WashCopingDataFragment extends BaseQuestionFragment {

    public static WashCopingDataFragment newInstance() {
        return new WashCopingDataFragment();
    }

    public WashCopingDataFragment() {
        setFragmentTag(WASH_COPING.toString());
    }
}

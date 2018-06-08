package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_CONDITIONS;
import static com.rjdeleon.mvp_app.AppConstants.WashComponent.WASH_COPING;

public class WashConditionsFragment extends BaseQuestionFragment {

    public static WashConditionsFragment newInstance() {
        return new WashConditionsFragment();
    }

    public WashConditionsFragment() {
        setFragmentTag(WASH_CONDITIONS.toString());

    }
}

package com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.WASH_CONDITIONS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.WASH_COPING;

public class WashConditionsFragment extends BaseQuestionFragment {

    public static WashConditionsFragment newInstance() {
        return new WashConditionsFragment();
    }

    public WashConditionsFragment() {
        setFragmentTag(WASH_CONDITIONS.toString());

    }
}

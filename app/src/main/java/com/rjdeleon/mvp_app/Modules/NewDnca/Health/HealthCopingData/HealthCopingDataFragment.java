package com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthCopingData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_COPING;

public class HealthCopingDataFragment extends BaseQuestionFragment {

    public static HealthCopingDataFragment newInstance() {
        return new HealthCopingDataFragment();
    }

    public HealthCopingDataFragment() {
        setFragmentTag(HEALTH_COPING.toString());
    }
}

package com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.HealthComponent.HEALTH_COPING;

public class HealthCopingDataFragment extends BaseQuestionFragment {

    public static HealthCopingDataFragment newInstance() {
        return new HealthCopingDataFragment();
    }

    public HealthCopingDataFragment() {
        setFragmentTag(HEALTH_COPING.toString());
    }
}

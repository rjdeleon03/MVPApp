package com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.HealthComponent.HEALTH_GAPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthGapsDataFragment extends BaseQuestionFragment {

    public static HealthGapsDataFragment newInstance() {
        return new HealthGapsDataFragment();
    }

    public HealthGapsDataFragment() {
        setFragmentTag(HEALTH_GAPS.toString());
    }
}

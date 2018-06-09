package com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthGapsData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_GAPS;

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

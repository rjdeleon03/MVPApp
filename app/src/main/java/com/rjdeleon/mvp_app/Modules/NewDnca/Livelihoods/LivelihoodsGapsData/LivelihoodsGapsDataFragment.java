package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsGapsData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_GAPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsGapsDataFragment extends BaseQuestionFragment {

    public static LivelihoodsGapsDataFragment newInstance() {
        return new LivelihoodsGapsDataFragment();
    }

    public LivelihoodsGapsDataFragment() {
        setFragmentTag(LIVELIHOODS_GAPS.toString());
    }
}

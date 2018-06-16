package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsGapsData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_GAPS;

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

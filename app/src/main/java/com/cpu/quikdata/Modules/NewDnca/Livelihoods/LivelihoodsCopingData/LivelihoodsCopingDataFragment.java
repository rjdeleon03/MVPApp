package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsCopingData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_COPING;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsCopingDataFragment extends BaseQuestionFragment {

    public static LivelihoodsCopingDataFragment newInstance() {
        return new LivelihoodsCopingDataFragment();
    }

    public LivelihoodsCopingDataFragment() {
        setFragmentTag(LIVELIHOODS_COPING.toString());
    }
}

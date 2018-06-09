package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsCopingData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_COPING;

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

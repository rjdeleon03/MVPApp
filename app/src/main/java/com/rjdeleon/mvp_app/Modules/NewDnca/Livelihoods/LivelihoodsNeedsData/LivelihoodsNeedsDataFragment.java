package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData;


import android.support.v4.app.Fragment;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsNeedsDataFragment extends BaseQuestionFragment {

    public static LivelihoodsNeedsDataFragment newInstance() {
        return new LivelihoodsNeedsDataFragment();
    }

    public LivelihoodsNeedsDataFragment() {
        setFragmentTag(LIVELIHOODS_NEEDS.toString());
    }
}

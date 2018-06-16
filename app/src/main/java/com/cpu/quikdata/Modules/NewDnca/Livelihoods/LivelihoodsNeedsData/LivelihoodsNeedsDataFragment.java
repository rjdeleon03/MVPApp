package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_NEEDS;

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

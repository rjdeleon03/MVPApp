package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsNeedsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class LivelihoodsNeedsDetailsFragment extends TemplateQuestionFragment {

    public LivelihoodsNeedsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_NEEDS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static LivelihoodsNeedsDetailsFragment newInstance() {

        return new LivelihoodsNeedsDetailsFragment();
    }
}

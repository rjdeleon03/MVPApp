package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsGapsDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class LivelihoodsGapsDetailsFragment extends TemplateQuestionFragment {

    public LivelihoodsGapsDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_GAPS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static LivelihoodsGapsDetailsFragment newInstance() {

        return new LivelihoodsGapsDetailsFragment();
    }
}

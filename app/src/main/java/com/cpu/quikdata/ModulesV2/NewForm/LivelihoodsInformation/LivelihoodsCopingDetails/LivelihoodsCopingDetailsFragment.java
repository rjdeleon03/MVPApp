package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsCopingDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class LivelihoodsCopingDetailsFragment extends TemplateQuestionFragment {

    public LivelihoodsCopingDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_COPING.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static LivelihoodsCopingDetailsFragment newInstance() {

        return new LivelihoodsCopingDetailsFragment();
    }
}

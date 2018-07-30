package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationWashDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationWashDetailsFragment extends TemplateQuestionFragment {

    public EvacuationWashDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM_WASH.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationWashDetailsFragment newInstance() {

        return new EvacuationWashDetailsFragment();
    }
}

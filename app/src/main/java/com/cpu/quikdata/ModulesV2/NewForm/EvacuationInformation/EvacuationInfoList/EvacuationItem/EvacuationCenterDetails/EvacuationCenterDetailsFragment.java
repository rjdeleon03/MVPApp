package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationCenterDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationCenterDetailsFragment extends TemplateQuestionFragment {

    public EvacuationCenterDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM_CENTER.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationCenterDetailsFragment newInstance() {

        return new EvacuationCenterDetailsFragment();
    }
}

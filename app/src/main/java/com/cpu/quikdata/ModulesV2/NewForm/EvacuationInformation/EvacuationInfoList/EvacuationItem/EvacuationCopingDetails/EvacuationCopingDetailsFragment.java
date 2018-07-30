package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationCopingDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationCopingDetailsFragment extends TemplateQuestionFragment {

    public EvacuationCopingDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM_COPING.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationCopingDetailsFragment newInstance() {

        return new EvacuationCopingDetailsFragment();
    }
}

package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationProtectionDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationProtectionDetailsFragment extends TemplateQuestionFragment {

    public EvacuationProtectionDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM_PROTECTION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationProtectionDetailsFragment newInstance() {

        return new EvacuationProtectionDetailsFragment();
    }
}

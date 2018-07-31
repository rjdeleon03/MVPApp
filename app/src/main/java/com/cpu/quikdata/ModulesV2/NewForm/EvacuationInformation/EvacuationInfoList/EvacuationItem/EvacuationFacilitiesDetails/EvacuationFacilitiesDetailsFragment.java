package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationFacilitiesDetails;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationFacilitiesDetailsFragment extends TemplateQuestionFragment {

    public EvacuationFacilitiesDetailsFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM_FACILITIES.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationFacilitiesDetailsFragment newInstance() {

        return new EvacuationFacilitiesDetailsFragment();
    }
}

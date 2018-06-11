package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSiteData;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.cpu.quikdata.AppConstants.EvacuationComponent.EVACUATION_SECURITY;
import static com.cpu.quikdata.AppConstants.EvacuationComponent.EVACUATION_SITE;

public class EvacuationSiteDataFragment extends BaseQuestionFragment {

    public static EvacuationSiteDataFragment newInstance() {
        return new EvacuationSiteDataFragment();
    }

    public EvacuationSiteDataFragment() {
        setFragmentTag(EVACUATION_SITE.toString());
    }
}

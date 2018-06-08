package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSiteData;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;

import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_SECURITY;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_SITE;

public class EvacuationSiteDataFragment extends BaseQuestionFragment {

    public static EvacuationSiteDataFragment newInstance() {
        return new EvacuationSiteDataFragment();
    }

    public EvacuationSiteDataFragment() {
        setFragmentTag(EVACUATION_SITE.toString());
    }
}

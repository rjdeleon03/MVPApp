package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation;

import com.cpu.quikdata.ModulesV2.NewForm.Base.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class GeneralInformationFragment extends TemplateMultiPageFragment<GeneralInformationViewModel> {

    public GeneralInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }
}

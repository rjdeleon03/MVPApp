package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation;

import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class ShelterInformationFragment extends TemplateMultiPageFragment<ShelterInformationViewModel> {

    public ShelterInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_INFO.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterInformationFragment newInstance() {
        return new ShelterInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {

    }
}

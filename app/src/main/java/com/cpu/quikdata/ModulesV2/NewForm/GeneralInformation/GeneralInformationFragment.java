package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CalamityDetails;
import com.cpu.quikdata.ModulesV2.NewForm.Base.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ViewFactory;

public class GeneralInformationFragment extends TemplateMultiPageFragment<GeneralInformationViewModel> {

    public GeneralInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO.toString();
    }

    /**
     * Sets up the custom view for whichever fragment extends this class
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {

        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup calamity details fragment
            CalamityDetailsFragment calamityDetailsFragment =
                    (CalamityDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY);
            calamityDetailsFragment.setViewModel(
                    (CalamityDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY, null, getContext()));
            mAdapter.addFragment(calamityDetailsFragment);
        }
    }

    /**
     * Gets new instance
     * @return
     */
    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }
}

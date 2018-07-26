package com.cpu.quikdata.ModulesV2.NewForm.WashInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails.ShelterCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails.ShelterCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails.ShelterGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails.ShelterGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData.ShelterNeedsDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData.ShelterNeedsDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashAssistanceData.WashAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashAssistanceData.WashAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails.WashConditionsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails.WashConditionsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashCopingDetails.WashCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashCopingDetails.WashCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashGapsDetails.WashGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashGapsDetails.WashGapsDetailsViewModel;
import com.cpu.quikdata.ViewFactory;

public class WashInformationFragment extends TemplateMultiPageFragment<WashInformationViewModel> {

    public WashInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.WASH.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static WashInformationFragment newInstance() {
        return new WashInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {
        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup wash conditions details fragment
            WashConditionsDetailsFragment washConditionsDetailsFragment =
                    (WashConditionsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.WASH_CONDITIONS);
            washConditionsDetailsFragment.setViewModel(
                    (WashConditionsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.WASH_CONDITIONS, null, getContext()));
            mAdapter.addFragment(washConditionsDetailsFragment);
        }

        {
            // Setup wash coping details fragment
            WashCopingDetailsFragment washCopingDetailsFragment =
                    (WashCopingDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.WASH_COPING);
            washCopingDetailsFragment.setViewModel(
                    (WashCopingDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.WASH_COPING, null, getContext()));
            mAdapter.addFragment(washCopingDetailsFragment);
        }

        {
            // Setup wash assistance data fragment
            WashAssistanceDataFragment washAssistanceDataFragment =
                    (WashAssistanceDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.WASH_ASSISTANCE);
            WashAssistanceDataViewModel washAssistanceDataViewModel =
                    (WashAssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.WASH_ASSISTANCE, null, getContext());
            washAssistanceDataViewModel.setViewComponent(washAssistanceDataFragment);
            washAssistanceDataFragment.setViewModel(washAssistanceDataViewModel);
            mAdapter.addFragment(washAssistanceDataFragment);
        }

        {
            // Setup wash gaps details fragment
            WashGapsDetailsFragment washGapsDetailsFragment =
                    (WashGapsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.WASH_GAPS);
            washGapsDetailsFragment.setViewModel(
                    (WashGapsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.WASH_GAPS, null, getContext()));
            mAdapter.addFragment(washGapsDetailsFragment);
        }
    }
}

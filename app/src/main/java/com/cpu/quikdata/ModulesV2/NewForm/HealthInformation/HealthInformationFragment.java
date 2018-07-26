package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData.DiseasesDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData.DiseasesDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthAssistanceData.HealthAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthAssistanceData.HealthAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthCopingDetails.HealthCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthCopingDetails.HealthCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthGapsDetails.HealthGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthGapsDetails.HealthGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData.PsychosocialDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData.PsychosocialDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData.SpecialNeedsDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData.SpecialNeedsDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ViewFactory;

public class HealthInformationFragment extends TemplateMultiPageFragment<HealthInformationViewModel> {

    public HealthInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static HealthInformationFragment newInstance() {
        return new HealthInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {

        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup diseases data fragment
            DiseasesDataFragment diseasesDataFragment =
                    (DiseasesDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_DISEASES);
            DiseasesDataViewModel diseasesDataViewModel =
                    (DiseasesDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_DISEASES, null, getContext());
            diseasesDataViewModel.setViewComponent(diseasesDataFragment);
            diseasesDataFragment.setViewModel(diseasesDataViewModel);
            mAdapter.addFragment(diseasesDataFragment);
        }

        {
            // Setup special needs data fragment
            SpecialNeedsDataFragment specialNeedsDataFragment =
                    (SpecialNeedsDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_SPECIAL_NEEDS);
            SpecialNeedsDataViewModel specialNeedsDataViewModel =
                    (SpecialNeedsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_SPECIAL_NEEDS, null, getContext());
            specialNeedsDataViewModel.setViewComponent(specialNeedsDataFragment);
            specialNeedsDataFragment.setViewModel(specialNeedsDataViewModel);
            mAdapter.addFragment(specialNeedsDataFragment);
        }

        {
            // Setup psychosocial data fragment
            PsychosocialDataFragment psychosocialDataFragment =
                    (PsychosocialDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_PSYCHOSOCIAL);
            PsychosocialDataViewModel psychosocialDataViewModel =
                    (PsychosocialDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_PSYCHOSOCIAL, null, getContext());
            psychosocialDataViewModel.setViewComponent(psychosocialDataFragment);
            psychosocialDataFragment.setViewModel(psychosocialDataViewModel);
            mAdapter.addFragment(psychosocialDataFragment);
        }
        
        {
            // Setup health coping details fragment
            HealthCopingDetailsFragment healthCopingDetailsFragment =
                    (HealthCopingDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_COPING);
            healthCopingDetailsFragment.setViewModel(
                    (HealthCopingDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_COPING, null, getContext()));
            mAdapter.addFragment(healthCopingDetailsFragment);
        }

        {
            // Setup health assistance data fragment
            HealthAssistanceDataFragment healthAssistanceDataFragment =
                    (HealthAssistanceDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_ASSISTANCE);
            HealthAssistanceDataViewModel healthAssistanceDataViewModel =
                    (HealthAssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_ASSISTANCE, null, getContext());
            healthAssistanceDataViewModel.setViewComponent(healthAssistanceDataFragment);
            healthAssistanceDataFragment.setViewModel(healthAssistanceDataViewModel);
            mAdapter.addFragment(healthAssistanceDataFragment);
        }

        {
            // Setup health gaps details fragment
            HealthGapsDetailsFragment healthGapsDetailsFragment =
                    (HealthGapsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_GAPS);
            healthGapsDetailsFragment.setViewModel(
                    (HealthGapsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.HEALTH_GAPS, null, getContext()));
            mAdapter.addFragment(healthGapsDetailsFragment);
        }

    }
}

package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData.DiseasesDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData.DiseasesDataViewModel;
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
        /**
        {
            // Setup calamity details fragment
            CalamityDetailsFragment calamityDetailsFragment =
                    (CalamityDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY);
            calamityDetailsFragment.setViewModel(
                    (CalamityDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY, null, getContext()));
            mAdapter.addFragment(calamityDetailsFragment);
        }

        {
            // Setup population data fragment
            SpecialNeedsDataFragment populationDataFragment =
                    (SpecialNeedsDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_POPULATION);
            SpecialNeedsDataViewModel populationDataViewModel =
                    (SpecialNeedsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_POPULATION, null, getContext());
            populationDataViewModel.setViewComponent(populationDataFragment);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);
        }
        */

    }
}

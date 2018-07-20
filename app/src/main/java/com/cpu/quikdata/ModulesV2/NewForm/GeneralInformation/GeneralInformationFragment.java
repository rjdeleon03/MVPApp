package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData.CasualtiesDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData.CasualtiesDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData.DeathCauseDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData.DeathCauseDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails.FamilyDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails.FamilyDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData.InfrastructureDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData.InfrastructureDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.PopulationDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData.VulnerableDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData.VulnerableDataViewModel;
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
        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment =
                    (PopulationDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_POPULATION);
            PopulationDataViewModel populationDataViewModel =
                    (PopulationDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_POPULATION, null, getContext());
            populationDataViewModel.setViewComponent(populationDataFragment);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);
        }
        {
            // Setup family details fragment
            FamilyDetailsFragment familyDetailsFragment =
                    (FamilyDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_FAMILY);
            familyDetailsFragment.setViewModel(
                    (FamilyDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_FAMILY, null, getContext()));
            mAdapter.addFragment(familyDetailsFragment);
        }
        {
            // Setup vulnerable data fragment
            VulnerableDataFragment vulnerableDataFragment =
                    (VulnerableDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_VULNERABLE);
            VulnerableDataViewModel vulnerableDataViewModel =
                    (VulnerableDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_VULNERABLE, null, getContext());
            vulnerableDataViewModel.setViewComponent(vulnerableDataFragment);
            vulnerableDataFragment.setViewModel(vulnerableDataViewModel);
            mAdapter.addFragment(vulnerableDataFragment);
        }
        {
            // Setup casualties data fragment
            CasualtiesDataFragment casualtiesDataFragment =
                    (CasualtiesDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CASUALTIES);
            CasualtiesDataViewModel casualtiesDataViewModel =
                    (CasualtiesDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CASUALTIES, null, getContext());
            casualtiesDataViewModel.setViewComponent(casualtiesDataFragment);
            casualtiesDataFragment.setViewModel(casualtiesDataViewModel);
            mAdapter.addFragment(casualtiesDataFragment);
        }
        {
            // Setup deathCause data fragment
            DeathCauseDataFragment deathCauseDataFragment =
                    (DeathCauseDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_DEATH_CAUSE);
            DeathCauseDataViewModel deathCauseDataViewModel =
                    (DeathCauseDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_DEATH_CAUSE, null, getContext());
            deathCauseDataViewModel.setViewComponent(deathCauseDataFragment);
            deathCauseDataFragment.setViewModel(deathCauseDataViewModel);
            mAdapter.addFragment(deathCauseDataFragment);
        }
        {
            // Setup infrastructure data fragment
            InfrastructureDataFragment infrastructureDataFragment =
                    (InfrastructureDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_INFRASTRUCTURE);
            InfrastructureDataViewModel infrastructureDataViewModel =
                    (InfrastructureDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_INFRASTRUCTURE, null, getContext());
            infrastructureDataViewModel.setViewComponent(infrastructureDataFragment);
            infrastructureDataFragment.setViewModel(infrastructureDataViewModel);
            mAdapter.addFragment(infrastructureDataFragment);
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

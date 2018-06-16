package com.cpu.quikdata.Modules.NewDnca.GeneralInformation;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_CALAMITY;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_CASUALTIES;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_DEATH_CAUSE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_FAMILY;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_INFRASTRUCTURE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_POPULATION;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_VULNERABLE;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenInfoFragment extends BaseMultiPageFragment {

    public static GenInfoFragment newInstance() {
        return new GenInfoFragment();
    }

    public GenInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        GenInfoRepositoryManager repositoryManager = (GenInfoRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup calamity details fragment
            CalamityDetailsFragment calamityDetailsFragment =
                    (CalamityDetailsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_CALAMITY);
            calamityDetailsFragment.setViewModel(
                    (CalamityDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_CALAMITY, repositoryManager, appContext));
            mAdapter.addFragment(calamityDetailsFragment);
        }

        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment =
                    (PopulationDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_POPULATION);
            populationDataFragment.setViewModel(
                    (PopulationDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_POPULATION, repositoryManager, appContext));
            mAdapter.addFragment(populationDataFragment);
        }

        {
            // Setup family data fragment
            FamilyDataFragment familyDataFragment =
                    (FamilyDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_FAMILY);
            familyDataFragment.setViewModel(
                    (FamilyDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_FAMILY, repositoryManager, appContext));
            mAdapter.addFragment(familyDataFragment);
        }

        {
            // Setup vulnerable population fragment
            VulnerablePopulationFragment vulnerablePopulationFragment =
                    (VulnerablePopulationFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_VULNERABLE);
            vulnerablePopulationFragment.setViewModel(
                    (VulnerablePopulationViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_VULNERABLE, repositoryManager, appContext));
            mAdapter.addFragment(vulnerablePopulationFragment);
        }

        {
            // Setup casualties data fragment
            CasualtiesDataFragment casualtiesDataFragment =
                    (CasualtiesDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_CASUALTIES);
            casualtiesDataFragment.setViewModel(
                    (CasualtiesDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_CASUALTIES, repositoryManager, appContext));
            mAdapter.addFragment(casualtiesDataFragment);
        }

        {
            // Setup death cause data fragment
            DeathCauseDataFragment deathCauseDataFragment =
                    (DeathCauseDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_DEATH_CAUSE);
            deathCauseDataFragment.setViewModel(
                    (DeathCauseDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_DEATH_CAUSE, repositoryManager, appContext));
            mAdapter.addFragment(deathCauseDataFragment);
        }

        {
            // Setup infrastructure damage fragment
            InfrastructureDamageFragment infrastructureDamageFragment =
                    (InfrastructureDamageFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, GEN_INFO_INFRASTRUCTURE);
            infrastructureDamageFragment.setViewModel(
                    (InfrastructureDamageViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, GEN_INFO_INFRASTRUCTURE, repositoryManager, appContext));
            mAdapter.addFragment(infrastructureDamageFragment);
        }
        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

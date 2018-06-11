package com.cpu.quikdata.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_CALAMITY;
import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_CASUALTIES;
import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_DEATH_CAUSE;
import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_FAMILY;
import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_INFRASTRUCTURE;
import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_POPULATION;
import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_VULNERABLE;
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

        {
            // Setup calamity details fragment
            CalamityDetailsFragment calamityDetailsFragment = (CalamityDetailsFragment)findOrCreateViewFragment(GEN_INFO_CALAMITY);
            calamityDetailsFragment.setViewModel((CalamityDetailsViewModel)findOrCreateViewModel(GEN_INFO_CALAMITY));
            mAdapter.addFragment(calamityDetailsFragment);
        }

        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment = (PopulationDataFragment)findOrCreateViewFragment(GEN_INFO_POPULATION);
            populationDataFragment.setViewModel((PopulationDataViewModel)findOrCreateViewModel(GEN_INFO_POPULATION));
            mAdapter.addFragment(populationDataFragment);
        }

        {
            // Setup family data fragment
            FamilyDataFragment familyDataFragment = (FamilyDataFragment)findOrCreateViewFragment(GEN_INFO_FAMILY);
            familyDataFragment.setViewModel((FamilyDataViewModel)findOrCreateViewModel(GEN_INFO_FAMILY));
            mAdapter.addFragment(familyDataFragment);
        }

        {
            // Setup vulnerable population fragment
            VulnerablePopulationFragment vulnerablePopulationFragment = (VulnerablePopulationFragment)findOrCreateViewFragment(GEN_INFO_VULNERABLE);
            vulnerablePopulationFragment.setViewModel((VulnerablePopulationViewModel)findOrCreateViewModel(GEN_INFO_VULNERABLE));
            mAdapter.addFragment(vulnerablePopulationFragment);
        }

        {
            // Setup casualties data fragment
            CasualtiesDataFragment casualtiesDataFragment = (CasualtiesDataFragment)findOrCreateViewFragment(GEN_INFO_CASUALTIES);
            casualtiesDataFragment.setViewModel((CasualtiesDataViewModel)findOrCreateViewModel(GEN_INFO_CASUALTIES));
            mAdapter.addFragment(casualtiesDataFragment);
        }

        {
            // Setup death cause data fragment
            DeathCauseDataFragment deathCauseDataFragment = (DeathCauseDataFragment)findOrCreateViewFragment(GEN_INFO_DEATH_CAUSE);
            deathCauseDataFragment.setViewModel((DeathCauseDataViewModel)findOrCreateViewModel(GEN_INFO_DEATH_CAUSE));
            mAdapter.addFragment(deathCauseDataFragment);
        }

        {
            // Setup infrastructure damage fragment
            InfrastructureDamageFragment infrastructureDamageFragment = (InfrastructureDamageFragment)findOrCreateViewFragment(GEN_INFO_INFRASTRUCTURE);
            infrastructureDamageFragment.setViewModel((InfrastructureDamageViewModel)findOrCreateViewModel(GEN_INFO_INFRASTRUCTURE));
            mAdapter.addFragment(infrastructureDamageFragment);
        }
        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

    /**
     * Finds the fragment of the specified type;
     * Creates the fragment if it does not exist
     * @param fragmentType
     * @return
     */
    @NonNull
    private Fragment findOrCreateViewFragment(AppConstants.GenInfoComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(getChildFragmentManager(), fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {
                case GEN_INFO_CALAMITY:
                    selectedFragment = CalamityDetailsFragment.newInstance();
                    break;
                case GEN_INFO_POPULATION:
                    selectedFragment = PopulationDataFragment.newInstance();
                    break;
                case GEN_INFO_FAMILY:
                    selectedFragment = FamilyDataFragment.newInstance();
                    break;
                case GEN_INFO_VULNERABLE:
                    selectedFragment = VulnerablePopulationFragment.newInstance();
                    break;
                case GEN_INFO_CASUALTIES:
                    selectedFragment = CasualtiesDataFragment.newInstance();
                    break;
                case GEN_INFO_DEATH_CAUSE:
                    selectedFragment = DeathCauseDataFragment.newInstance();
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    selectedFragment = InfrastructureDamageFragment.newInstance();
                    break;
            }
        }
        return selectedFragment;
    }

    /**
     * Finds the viewModel of the specified type;
     * Creates the viewModel if it does not exist
     * @param fragmentType
     * @return
     */
    @NonNull
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.GenInfoComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);

        // Setup specific repository manager
        GenInfoRepositoryManager repositoryManager = (GenInfoRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case GEN_INFO_CALAMITY:
                    viewModel = new CalamityDetailsViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case GEN_INFO_POPULATION:
                    viewModel = new PopulationDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case GEN_INFO_FAMILY:
                    viewModel = new FamilyDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case GEN_INFO_VULNERABLE:
                    viewModel = new VulnerablePopulationViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case GEN_INFO_CASUALTIES:
                    viewModel = new CasualtiesDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case GEN_INFO_DEATH_CAUSE:
                    viewModel = new DeathCauseDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    viewModel = new InfrastructureDamageViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.NewDncaActivity;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

import java.util.List;

import static com.rjdeleon.mvp_app.AppConstants.VIEWMODEL_TAG;

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
            CalamityDetailsFragment calamityDetailsFragment = (CalamityDetailsFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.CALAMITY);
            CalamityDetailsViewModel calamityDetailsViewModel = (CalamityDetailsViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.CALAMITY);
            calamityDetailsFragment.setViewModel(calamityDetailsViewModel);
            mAdapter.addFragment(calamityDetailsFragment);
        }

        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment = (PopulationDataFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.POPULATION);
            PopulationDataViewModel populationDataViewModel = (PopulationDataViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.POPULATION);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);
        }

        {
            // Setup family data fragment
            FamilyDataFragment familyDataFragment = (FamilyDataFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.FAMILY);
            FamilyDataViewModel familyDataViewModel = (FamilyDataViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.FAMILY);
            familyDataFragment.setViewModel(familyDataViewModel);
            mAdapter.addFragment(familyDataFragment);
        }

        {
            // Setup vulnerable population fragment
            VulnerablePopulationFragment vulnerablePopulationFragment = (VulnerablePopulationFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.VULNERABLE);
            VulnerablePopulationViewModel vulnerablePopulationViewModel = (VulnerablePopulationViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.VULNERABLE);
            vulnerablePopulationFragment.setViewModel(vulnerablePopulationViewModel);
            mAdapter.addFragment(vulnerablePopulationFragment);
        }

        {
            // Setup casualties data fragment
            CasualtiesDataFragment casualtiesDataFragment = (CasualtiesDataFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.CASUALTIES);
            CasualtiesDataViewModel casualtiesDataViewModel = (CasualtiesDataViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.CASUALTIES);
            casualtiesDataFragment.setViewModel(casualtiesDataViewModel);
            mAdapter.addFragment(casualtiesDataFragment);
        }

        {
            // Setup death cause data fragment
            DeathCauseDataFragment deathCauseDataFragment = (DeathCauseDataFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.DEATH_CAUSE);
            DeathCauseDataViewModel deathCauseDataViewModel = (DeathCauseDataViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.DEATH_CAUSE);
            deathCauseDataFragment.setViewModel(deathCauseDataViewModel);
            mAdapter.addFragment(deathCauseDataFragment);
        }

        {
            // Setup infrastructure damage fragment
            InfrastructureDamageFragment infrastructureDamageFragment = (InfrastructureDamageFragment)findOrCreateViewFragment(AppConstants.GenInfoComponent.INFRASTRUCTURE);
            InfrastructureDamageViewModel infrastructureDamageViewModel = (InfrastructureDamageViewModel)findOrCreateViewModel(AppConstants.GenInfoComponent.INFRASTRUCTURE);
            infrastructureDamageFragment.setViewModel(infrastructureDamageViewModel);
            mAdapter.addFragment(infrastructureDamageFragment);
        }
        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

    @NonNull
    private Fragment findOrCreateViewFragment(AppConstants.GenInfoComponent fragmentType) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        BaseSubFragment selectedFragment = null;
        for(Fragment fragment : fragments) {
            if (!(fragment instanceof BaseSubFragment)) continue;

            selectedFragment = (BaseSubFragment)fragment;
            if ((selectedFragment.getFragmentTag().equals(fragmentType.toString()))) {
                break;
            }
            selectedFragment = null;
        }
        if (selectedFragment == null) {
            switch(fragmentType) {
                case CALAMITY:
                    selectedFragment = CalamityDetailsFragment.newInstance();
                    break;
                case POPULATION:
                    selectedFragment = PopulationDataFragment.newInstance();
                    break;
                case FAMILY:
                    selectedFragment = FamilyDataFragment.newInstance();
                    break;
                case VULNERABLE:
                    selectedFragment = VulnerablePopulationFragment.newInstance();
                    break;
                case CASUALTIES:
                    selectedFragment = CasualtiesDataFragment.newInstance();
                    break;
                case DEATH_CAUSE:
                    selectedFragment = DeathCauseDataFragment.newInstance();
                    break;
                case INFRASTRUCTURE:
                    selectedFragment = InfrastructureDamageFragment.newInstance();
                    break;
            }
        }
        return selectedFragment;
    }

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
                case CALAMITY:
                    viewModel = new CalamityDetailsViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case POPULATION:
                    viewModel = new PopulationDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case FAMILY:
                    viewModel = new FamilyDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case VULNERABLE:
                    viewModel = new VulnerablePopulationViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case CASUALTIES:
                    viewModel = new CasualtiesDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case DEATH_CAUSE:
                    viewModel = new DeathCauseDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case INFRASTRUCTURE:
                    viewModel = new InfrastructureDamageViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            if (retainedViewModel != null) {
                // If container already exists, just inject viewModel into container
                retainedViewModel.setViewModel(viewModel);

            } else {

                // Bind viewModel to activity's lifecycle using fragment manager
                ActivityUtils.addFragmentToActivity(
                        getChildFragmentManager(),
                        ViewModelHolder.createContainer(viewModel),
                        tag);
            }
        }
        return viewModel;
    }
}

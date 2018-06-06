package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class GenInfoFragment extends BaseMultiPageFragment {

    private enum GenInfoComponent {
        CALAMITY,
        POPULATION,
        FAMILY,
        VULNERABLE,
        CASUALTIES,
        DEATH_CAUSE,
        INFRASTRUCTURE
    }

    public static final String GEN_INFO_CALAMITY_VIEWMODEL_TAG = "GEN_INFO_CALAMITY_VIEWMODEL_TAG";
    public static final String GEN_INFO_POPULATION_VIEWMODEL_TAG = "GEN_INFO_POPULATION_VIEWMODEL_TAG";
    public static final String GEN_INFO_FAMILY_VIEWMODEL_TAG = "GEN_INFO_FAMILY_VIEWMODEL_TAG";
    public static final String GEN_INFO_VULNERABLE_VIEWMODEL_TAG = "GEN_INFO_VULNERABLE_VIEWMODEL_TAG";
    public static final String GEN_INFO_CASUALTIES_VIEWMODEL_TAG = "GEN_INFO_CASUALTIES_VIEWMODEL_TAG";
    public static final String GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG = "GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG";
    public static final String GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG = "GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG";

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
            CalamityDetailsFragment calamityDetailsFragment = (CalamityDetailsFragment)findOrCreateViewFragment(GenInfoComponent.CALAMITY);
            CalamityDetailsViewModel calamityDetailsViewModel = (CalamityDetailsViewModel)findOrCreateViewModel(GenInfoComponent.CALAMITY);
            calamityDetailsFragment.setViewModel(calamityDetailsViewModel);
            mAdapter.addFragment(calamityDetailsFragment);

            // Bind calamity details viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(calamityDetailsViewModel),
                    GEN_INFO_CALAMITY_VIEWMODEL_TAG);
        }

        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment = (PopulationDataFragment)findOrCreateViewFragment(GenInfoComponent.POPULATION);
            PopulationDataViewModel populationDataViewModel = (PopulationDataViewModel)findOrCreateViewModel(GenInfoComponent.POPULATION);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);

            // Bind population data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(populationDataViewModel),
                    GEN_INFO_POPULATION_VIEWMODEL_TAG);
        }
/*
        {
            // Setup family data fragment
            FamilyDataFragment familyDataFragment = (FamilyDataFragment)findOrCreateViewFragment(GenInfoComponent.FAMILY);
            FamilyDataViewModel familyDataViewModel = (FamilyDataViewModel)findOrCreateViewModel(GenInfoComponent.FAMILY);
            familyDataFragment.setViewModel(familyDataViewModel);
            mAdapter.addFragment(familyDataFragment);

            // Bind family data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(familyDataViewModel),
                    GEN_INFO_FAMILY_VIEWMODEL_TAG);
        }

        {
            // Setup vulnerable population fragment
            VulnerablePopulationFragment vulnerablePopulationFragment = (VulnerablePopulationFragment)findOrCreateViewFragment(GenInfoComponent.VULNERABLE);
            VulnerablePopulationViewModel vulnerablePopulationViewModel = (VulnerablePopulationViewModel)findOrCreateViewModel(GenInfoComponent.VULNERABLE);
            vulnerablePopulationFragment.setViewModel(vulnerablePopulationViewModel);
            mAdapter.addFragment(vulnerablePopulationFragment);

            // Bind vulnerable population viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(vulnerablePopulationViewModel),
                    GEN_INFO_VULNERABLE_VIEWMODEL_TAG);
        }

        {
            // Setup casualties data fragment
            CasualtiesDataFragment casualtiesDataFragment = (CasualtiesDataFragment)findOrCreateViewFragment(GenInfoComponent.CASUALTIES);
            CasualtiesDataViewModel casualtiesDataViewModel = (CasualtiesDataViewModel)findOrCreateViewModel(GenInfoComponent.CASUALTIES);
            casualtiesDataFragment.setViewModel(casualtiesDataViewModel);
            mAdapter.addFragment(casualtiesDataFragment);

            // Bind casualties data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(casualtiesDataViewModel),
                    GEN_INFO_CASUALTIES_VIEWMODEL_TAG);
        }

        {
            // Setup death cause data fragment
            DeathCauseDataFragment deathCauseDataFragment = (DeathCauseDataFragment)findOrCreateViewFragment(GenInfoComponent.DEATH_CAUSE);
            DeathCauseDataViewModel deathCauseDataViewModel = (DeathCauseDataViewModel)findOrCreateViewModel(GenInfoComponent.DEATH_CAUSE);
            deathCauseDataFragment.setViewModel(deathCauseDataViewModel);
            mAdapter.addFragment(deathCauseDataFragment);

            // Bind death cause data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(deathCauseDataViewModel),
                    GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG);
        }

        {
            // Setup infrastructure damage fragment
            InfrastructureDamageFragment infrastructureDamageFragment = (InfrastructureDamageFragment)findOrCreateViewFragment(GenInfoComponent.INFRASTRUCTURE);
            InfrastructureDamageViewModel infrastructureDamageViewModel = (InfrastructureDamageViewModel)findOrCreateViewModel(GenInfoComponent.INFRASTRUCTURE);
            infrastructureDamageFragment.setViewModel(infrastructureDamageViewModel);
            mAdapter.addFragment(infrastructureDamageFragment);

            // Bind infrastructure damage viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(infrastructureDamageViewModel),
                    GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG);
        }
*/
        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

    @NonNull
    private Fragment findOrCreateViewFragment(GenInfoComponent fragmentType) {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Fragment selectedFragment = null;
        for(Fragment fragment : fragments) {
            if(fragment instanceof CalamityDetailsFragment && fragmentType == GenInfoComponent.CALAMITY ||
                    fragment instanceof PopulationDataFragment && fragmentType == GenInfoComponent.POPULATION ||
                    fragment instanceof FamilyDataFragment && fragmentType == GenInfoComponent.FAMILY ||
                    fragment instanceof VulnerablePopulationFragment && fragmentType == GenInfoComponent.VULNERABLE ||
                    fragment instanceof CasualtiesDataFragment && fragmentType == GenInfoComponent.CASUALTIES ||
                    fragment instanceof DeathCauseDataFragment && fragmentType == GenInfoComponent.DEATH_CAUSE ||
                    fragment instanceof InfrastructureDamageFragment && fragmentType == GenInfoComponent.INFRASTRUCTURE) {
                selectedFragment = fragment;
                break;
            }
        }
        if (selectedFragment == null) {
            switch(fragmentType) {
                case CALAMITY:
                    return CalamityDetailsFragment.newInstance();
                case POPULATION:
                    return PopulationDataFragment.newInstance();
                case FAMILY:
                    return FamilyDataFragment.newInstance();
                case VULNERABLE:
                    return VulnerablePopulationFragment.newInstance();
                case CASUALTIES:
                    return CasualtiesDataFragment.newInstance();
                case DEATH_CAUSE:
                    return DeathCauseDataFragment.newInstance();
                case INFRASTRUCTURE:
                    return InfrastructureDamageFragment.newInstance();
            }
        }
        return selectedFragment;
    }

    @NonNull
    private NewDncaBaseViewModel findOrCreateViewModel(GenInfoComponent fragmentType) {

        // Setup specific repository manager
        GenInfoRepositoryManager repositoryManager = (GenInfoRepositoryManager) mViewModel;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = null;
        NewDncaBaseViewModel viewModel = null;
        String tag = null;
        switch(fragmentType) {
            case CALAMITY:
                tag = GEN_INFO_CALAMITY_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new CalamityDetailsViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
            case POPULATION:
                tag = GEN_INFO_POPULATION_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new PopulationDataViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
            case FAMILY:
                tag = GEN_INFO_FAMILY_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new FamilyDataViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
            case VULNERABLE:
                tag = GEN_INFO_VULNERABLE_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new VulnerablePopulationViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
            case CASUALTIES:
                tag = GEN_INFO_CASUALTIES_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new CasualtiesDataViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
            case DEATH_CAUSE:
                tag = GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new DeathCauseDataViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
            case INFRASTRUCTURE:
                tag = GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) viewModel = retainedViewModel.getViewmodel();
                viewModel = new InfrastructureDamageViewModel(getContext().getApplicationContext(), repositoryManager);
                break;
        }

        // Bind viewModel to activity's lifecycle using fragment manager
        ActivityUtils.addFragmentToActivity(
                getChildFragmentManager(),
                ViewModelHolder.createContainer(viewModel),
                tag);

        return viewModel;
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
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
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaGenInfoFragmentBinding;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaGenInfoFragment extends BaseMultiPageFragment {

    public static final String NEW_DNCA_GEN_INFO_CALAMITY_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_CALAMITY_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_POPULATION_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_POPULATION_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_FAMILY_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_FAMILY_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_VULNERABLE_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_VULNERABLE_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_CASUALTIES_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_CASUALTIES_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG";

    private NewDncaGenInfoViewModel mViewModel;
    private NewDncaGenInfoFragmentBinding mBinding;

    public static NewDncaGenInfoFragment newInstance() {
        return new NewDncaGenInfoFragment();
    }

    public NewDncaGenInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the view model
     * @param viewModel
     */
    public void setViewModel(@NonNull NewDncaGenInfoViewModel viewModel) {
        mViewModel = viewModel;
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

        // Bind viewModel to view
        if (mBinding == null) {
            mBinding = NewDncaGenInfoFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        {
            // Setup calamity details fragment
            CalamityDetailsFragment calamityDetailsFragment = CalamityDetailsFragment.newInstance();
            CalamityDetailsViewModel calamityDetailsViewModel = new CalamityDetailsViewModel(getContext().getApplicationContext(), mViewModel);
            calamityDetailsFragment.setViewModel(calamityDetailsViewModel);
            mAdapter.addFragment(calamityDetailsFragment);

            // Bind calamity details viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(calamityDetailsViewModel),
                    NEW_DNCA_GEN_INFO_CALAMITY_VIEWMODEL_TAG);
        }

        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment = PopulationDataFragment.newInstance();
            PopulationDataViewModel populationDataViewModel = new PopulationDataViewModel(getContext().getApplicationContext(), mViewModel);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);

            // Bind population data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(populationDataViewModel),
                    NEW_DNCA_GEN_INFO_POPULATION_VIEWMODEL_TAG);
        }

        {
            // Setup family data fragment
            FamilyDataFragment familyDataFragment = FamilyDataFragment.newInstance();
            FamilyDataViewModel familyDataViewModel = new FamilyDataViewModel(getContext().getApplicationContext(), mViewModel);
            familyDataFragment.setViewModel(familyDataViewModel);
            mAdapter.addFragment(familyDataFragment);

            // Bind family data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(familyDataViewModel),
                    NEW_DNCA_GEN_INFO_FAMILY_VIEWMODEL_TAG);
        }

        {
            // Setup vulnerable population fragment
            VulnerablePopulationFragment vulnerablePopulationFragment = VulnerablePopulationFragment.getInstance();
            VulnerablePopulationViewModel vulnerablePopulationViewModel = new VulnerablePopulationViewModel(getContext().getApplicationContext(), mViewModel);
            vulnerablePopulationFragment.setViewModel(vulnerablePopulationViewModel);
            mAdapter.addFragment(vulnerablePopulationFragment);

            // Bind vulnerable population viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(vulnerablePopulationViewModel),
                    NEW_DNCA_GEN_INFO_VULNERABLE_VIEWMODEL_TAG);
        }

        {
            // Setup casualties data fragment
            CasualtiesDataFragment casualtiesDataFragment = CasualtiesDataFragment.getInstance();
            CasualtiesDataViewModel casualtiesDataViewModel = new CasualtiesDataViewModel(getContext().getApplicationContext(), mViewModel);
            casualtiesDataFragment.setViewModel(casualtiesDataViewModel);
            mAdapter.addFragment(casualtiesDataFragment);

            // Bind casualties data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(casualtiesDataViewModel),
                    NEW_DNCA_GEN_INFO_CASUALTIES_VIEWMODEL_TAG);
        }

        {
            // Setup death cause data fragment
            DeathCauseDataFragment deathCauseDataFragment = DeathCauseDataFragment.getInstance();
            DeathCauseDataViewModel deathCauseDataViewModel = new DeathCauseDataViewModel(getContext().getApplicationContext(), mViewModel);
            deathCauseDataFragment.setViewModel(deathCauseDataViewModel);
            mAdapter.addFragment(deathCauseDataFragment);

            // Bind death cause data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(deathCauseDataViewModel),
                    NEW_DNCA_GEN_INFO_DEATH_CAUSE_VIEWMODEL_TAG);
        }

        {
            // Setup infrastructure damage fragment
            InfrastructureDamageFragment infrastructureDamageFragment = InfrastructureDamageFragment.getInstance();
            InfrastructureDamageViewModel infrastructureDamageViewModel = new InfrastructureDamageViewModel(getContext().getApplicationContext(), mViewModel);
            infrastructureDamageFragment.setViewModel(infrastructureDamageViewModel);
            mAdapter.addFragment(infrastructureDamageFragment);

            // Bind infrastructure damage viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(infrastructureDamageViewModel),
                    NEW_DNCA_GEN_INFO_INFRASTRUCTURE_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root, R.id.nd_gen_info_pager);

        return root;
    }
}

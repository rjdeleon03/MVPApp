package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationSiteData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationCopingData.EvacuationCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationFacilitiesData.EvacuationFacilitiesDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSecurityData.EvacuationSecurityDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationWashData.EvacuationWashDataViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationFragment extends BaseMultiPageFragment {

    public static final String EVACUATION_SITE_VIEWMODEL_TAG = "EVACUATION_SITE_VIEWMODEL_TAG";
    public static final String EVACUATION_POPULATION_VIEWMODEL_TAG = "EVACUATION_POPULATION_VIEWMODEL_TAG";
    public static final String EVACUATION_FACILITIES_VIEWMODEL_TAG = "EVACUATION_FACILITIES_VIEWMODEL_TAG";
    public static final String EVACUATION_WASH_VIEWMODEL_TAG = "EVACUATION_WASH_VIEWMODEL_TAG";
    public static final String EVACUATION_SECURITY_VIEWMODEL_TAG = "EVACUATION_SECURITY_VIEWMODEL_TAG";
    public static final String EVACUATION_COPING_VIEWMODEL_TAG = "EVACUATION_COPING_VIEWMODEL_TAG";

    public static EvacuationFragment newInstance() {
        return new EvacuationFragment();
    }

    public EvacuationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        // Setup specific repository manager
        EvacuationRepositoryManager repositoryManager = (EvacuationRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup evacuation site data fragment
            BaseQuestionFragment evacuationSiteDataFragment =  BaseQuestionFragment.newInstance();
            EvacuationSiteDataViewModel evacuationSiteDataViewModel = new  EvacuationSiteDataViewModel(getContext().getApplicationContext(), repositoryManager);
            evacuationSiteDataFragment.setViewModel(evacuationSiteDataViewModel);
            mAdapter.addFragment(evacuationSiteDataFragment);

            // Bind evacuation site data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(evacuationSiteDataViewModel),
                    EVACUATION_SITE_VIEWMODEL_TAG);
        }

        {
            // Setup population data fragment
            EvacuationPopulationFragment evacuationPopulationFragment =  EvacuationPopulationFragment.newInstance();
            EvacuationPopulationViewModel evacuationPopulationViewModel = new  EvacuationPopulationViewModel(getContext().getApplicationContext(), repositoryManager);
            evacuationPopulationFragment.setViewModel(evacuationPopulationViewModel);
            mAdapter.addFragment(evacuationPopulationFragment);

            // Bind population data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(evacuationPopulationViewModel),
                    EVACUATION_POPULATION_VIEWMODEL_TAG);
        }

        {
            // Setup facilities data fragment
            BaseQuestionFragment evacuationFacilitiesFragment =  BaseQuestionFragment.newInstance();
            EvacuationFacilitiesDataViewModel evacuationFacilitiesViewModel = new  EvacuationFacilitiesDataViewModel(getContext().getApplicationContext(), repositoryManager);
            evacuationFacilitiesFragment.setViewModel(evacuationFacilitiesViewModel);
            mAdapter.addFragment(evacuationFacilitiesFragment);

            // Bind facilities data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(evacuationFacilitiesViewModel),
                    EVACUATION_FACILITIES_VIEWMODEL_TAG);
        }

        {
            // Setup wash data fragment
            BaseQuestionFragment evacuationWashFragment =  BaseQuestionFragment.newInstance();
            EvacuationWashDataViewModel evacuationWashViewModel = new EvacuationWashDataViewModel(getContext().getApplicationContext(), repositoryManager);
            evacuationWashFragment.setViewModel(evacuationWashViewModel);
            mAdapter.addFragment(evacuationWashFragment);

            // Bind wash data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(evacuationWashViewModel),
                    EVACUATION_WASH_VIEWMODEL_TAG);
        }

        {
            // Setup security data fragment
            BaseQuestionFragment evacuationSecurityFragment =  BaseQuestionFragment.newInstance();
            EvacuationSecurityDataViewModel evacuationSecurityViewModel = new EvacuationSecurityDataViewModel(getContext().getApplicationContext(), repositoryManager);
            evacuationSecurityFragment.setViewModel(evacuationSecurityViewModel);
            mAdapter.addFragment(evacuationSecurityFragment);

            // Bind security data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(evacuationSecurityViewModel),
                    EVACUATION_SECURITY_VIEWMODEL_TAG);
        }

        {
            // Setup coping data fragment
            BaseQuestionFragment evacuationCopingFragment =  BaseQuestionFragment.newInstance();
            EvacuationCopingDataViewModel evacuationCopingViewModel = new EvacuationCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
            evacuationCopingFragment.setViewModel(evacuationCopingViewModel);
            mAdapter.addFragment(evacuationCopingFragment);

            // Bind coping data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(evacuationCopingViewModel),
                    EVACUATION_COPING_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

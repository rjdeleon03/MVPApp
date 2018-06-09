package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationSiteData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationCopingData.EvacuationCopingDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationCopingData.EvacuationCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationFacilitiesData.EvacuationFacilitiesDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationFacilitiesData.EvacuationFacilitiesDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSecurityData.EvacuationSecurityDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSecurityData.EvacuationSecurityDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationWashData.EvacuationWashDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationWashData.EvacuationWashDataViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_COPING;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_FACILITIES;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_POPULATION;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_SECURITY;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_SITE;
import static com.rjdeleon.mvp_app.AppConstants.EvacuationComponent.EVACUATION_WASH;
import static com.rjdeleon.mvp_app.AppConstants.VIEWMODEL_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationFragment extends BaseMultiPageFragment {

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
            EvacuationSiteDataFragment evacuationSiteDataFragment = (EvacuationSiteDataFragment)findOrCreateViewFragment(EVACUATION_SITE);
            evacuationSiteDataFragment.setViewModel((EvacuationSiteDataViewModel)findOrCreateViewModel(EVACUATION_SITE));
            mAdapter.addFragment(evacuationSiteDataFragment);
        }

        {
            // Setup population data fragment
            EvacuationPopulationFragment evacuationPopulationFragment = (EvacuationPopulationFragment)findOrCreateViewFragment(EVACUATION_POPULATION);
            evacuationPopulationFragment.setViewModel((EvacuationPopulationViewModel)findOrCreateViewModel(EVACUATION_POPULATION));
            mAdapter.addFragment(evacuationPopulationFragment);
        }

        {
            // Setup facilities data fragment
            EvacuationFacilitiesDataFragment evacuationFacilitiesDataFragment = (EvacuationFacilitiesDataFragment)findOrCreateViewFragment(EVACUATION_FACILITIES);
            evacuationFacilitiesDataFragment.setViewModel((EvacuationFacilitiesDataViewModel)findOrCreateViewModel(EVACUATION_FACILITIES));
            mAdapter.addFragment(evacuationFacilitiesDataFragment);
        }

        {
            // Setup wash data fragment
            EvacuationWashDataFragment evacuationWashDataFragment = (EvacuationWashDataFragment)findOrCreateViewFragment(EVACUATION_WASH);
            evacuationWashDataFragment.setViewModel((EvacuationWashDataViewModel)findOrCreateViewModel(EVACUATION_WASH));
            mAdapter.addFragment(evacuationWashDataFragment);
        }

        {
            // Setup security data fragment
            EvacuationSecurityDataFragment evacuationSecurityDataFragment = (EvacuationSecurityDataFragment)findOrCreateViewFragment(EVACUATION_SECURITY);
            evacuationSecurityDataFragment.setViewModel((EvacuationSecurityDataViewModel)findOrCreateViewModel(EVACUATION_SECURITY));
            mAdapter.addFragment(evacuationSecurityDataFragment);
        }

        {
            // Setup coping data fragment
            EvacuationCopingDataFragment evacuationCopingDataFragment = (EvacuationCopingDataFragment)findOrCreateViewFragment(EVACUATION_COPING);
            evacuationCopingDataFragment.setViewModel((EvacuationCopingDataViewModel)findOrCreateViewModel(EVACUATION_COPING));
            mAdapter.addFragment(evacuationCopingDataFragment);
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
    private Fragment findOrCreateViewFragment(AppConstants.EvacuationComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(getChildFragmentManager(), fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {
                case EVACUATION_SITE:
                    selectedFragment = EvacuationSiteDataFragment.newInstance();
                    break;
                case EVACUATION_POPULATION:
                    selectedFragment = EvacuationPopulationFragment.newInstance();
                    break;
                case EVACUATION_FACILITIES:
                    selectedFragment = EvacuationFacilitiesDataFragment.newInstance();
                    break;
                case EVACUATION_WASH:
                    selectedFragment = EvacuationWashDataFragment.newInstance();
                    break;
                case EVACUATION_SECURITY:
                    selectedFragment = EvacuationSecurityDataFragment.newInstance();
                    break;
                case EVACUATION_COPING:
                    selectedFragment = EvacuationCopingDataFragment.newInstance();
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
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.EvacuationComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);

        // Setup specific repository manager
        EvacuationRepositoryManager repositoryManager = (EvacuationRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case EVACUATION_SITE:
                    viewModel = new EvacuationSiteDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case EVACUATION_POPULATION:
                    viewModel = new EvacuationPopulationViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case EVACUATION_FACILITIES:
                    viewModel = new EvacuationFacilitiesDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case EVACUATION_WASH:
                    viewModel = new EvacuationWashDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case EVACUATION_SECURITY:
                    viewModel = new EvacuationSecurityDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case EVACUATION_COPING:
                    viewModel = new EvacuationCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

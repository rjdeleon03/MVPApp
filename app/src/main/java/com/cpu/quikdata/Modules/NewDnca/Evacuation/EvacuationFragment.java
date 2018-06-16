package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Models.Evacuation.EvacuationSiteData;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationCopingData.EvacuationCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationCopingData.EvacuationCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationFacilitiesData.EvacuationFacilitiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationFacilitiesData.EvacuationFacilitiesDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSecurityData.EvacuationSecurityDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSecurityData.EvacuationSecurityDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationWashData.EvacuationWashDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationWashData.EvacuationWashDataViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_FACILITIES;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_POPULATION;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_SECURITY;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_SITE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_WASH;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

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
            EvacuationSiteDataFragment evacuationSiteDataFragment =
                    (EvacuationSiteDataFragment) ViewFactory.findOrCreateViewFragment(getChildFragmentManager(), EVACUATION_SITE);
            evacuationSiteDataFragment.setViewModel((EvacuationSiteDataViewModel)findOrCreateViewModel(EVACUATION_SITE));
            mAdapter.addFragment(evacuationSiteDataFragment);
        }

        {
            // Setup population data fragment
            EvacuationPopulationFragment evacuationPopulationFragment =
                    (EvacuationPopulationFragment) ViewFactory.findOrCreateViewFragment(getChildFragmentManager(), EVACUATION_POPULATION);
            evacuationPopulationFragment.setViewModel((EvacuationPopulationViewModel)findOrCreateViewModel(EVACUATION_POPULATION));
            mAdapter.addFragment(evacuationPopulationFragment);
        }

        {
            // Setup facilities data fragment
            EvacuationFacilitiesDataFragment evacuationFacilitiesDataFragment =
                    (EvacuationFacilitiesDataFragment) ViewFactory.findOrCreateViewFragment(getChildFragmentManager(), EVACUATION_FACILITIES);
            evacuationFacilitiesDataFragment.setViewModel((EvacuationFacilitiesDataViewModel)findOrCreateViewModel(EVACUATION_FACILITIES));
            mAdapter.addFragment(evacuationFacilitiesDataFragment);
        }

        {
            // Setup wash data fragment
            EvacuationWashDataFragment evacuationWashDataFragment =
                    (EvacuationWashDataFragment) ViewFactory.findOrCreateViewFragment(getChildFragmentManager(), EVACUATION_WASH);
            evacuationWashDataFragment.setViewModel((EvacuationWashDataViewModel)findOrCreateViewModel(EVACUATION_WASH));
            mAdapter.addFragment(evacuationWashDataFragment);
        }

        {
            // Setup security data fragment
            EvacuationSecurityDataFragment evacuationSecurityDataFragment =
                    (EvacuationSecurityDataFragment) ViewFactory.findOrCreateViewFragment(getChildFragmentManager(), EVACUATION_SECURITY);
            evacuationSecurityDataFragment.setViewModel((EvacuationSecurityDataViewModel)findOrCreateViewModel(EVACUATION_SECURITY));
            mAdapter.addFragment(evacuationSecurityDataFragment);
        }

        {
            // Setup coping data fragment
            EvacuationCopingDataFragment evacuationCopingDataFragment = 
                    (EvacuationCopingDataFragment) ViewFactory.findOrCreateViewFragment(getChildFragmentManager(), EVACUATION_COPING);
            evacuationCopingDataFragment.setViewModel((EvacuationCopingDataViewModel)findOrCreateViewModel(EVACUATION_COPING));
            mAdapter.addFragment(evacuationCopingDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

    /**
     * Finds the viewModel of the specified type;
     * Creates the viewModel if it does not exist
     * @param fragmentType
     * @return
     */
    @NonNull
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.NewDncaComponent fragmentType) {

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

package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData.EvacuationCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData.EvacuationCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData.EvacuationFacilitiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData.EvacuationFacilitiesDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData.EvacuationSecurityDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData.EvacuationSecurityDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData.EvacuationSiteDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData.EvacuationSiteDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData.EvacuationWashDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData.EvacuationWashDataViewModel;
import com.cpu.quikdata.ViewFactory;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_FACILITIES;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_POPULATION;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_SECURITY;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_SITE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_WASH;

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

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        EvacuationItemRepositoryManager repositoryManager = (EvacuationItemRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup evacuation site data fragment
            EvacuationSiteDataFragment evacuationSiteDataFragment =
                    (EvacuationSiteDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, EVACUATION_SITE);
            evacuationSiteDataFragment.setViewModel(
                    (EvacuationSiteDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, EVACUATION_SITE, repositoryManager, appContext));
            mAdapter.addFragment(evacuationSiteDataFragment);
        }

        {
            // Setup population data fragment
            EvacuationPopulationFragment evacuationPopulationFragment =
                    (EvacuationPopulationFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, EVACUATION_POPULATION);
            evacuationPopulationFragment.setViewModel(
                    (EvacuationPopulationViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, EVACUATION_POPULATION, repositoryManager, appContext));
            mAdapter.addFragment(evacuationPopulationFragment);
        }

        {
            // Setup facilities data fragment
            EvacuationFacilitiesDataFragment evacuationFacilitiesDataFragment =
                    (EvacuationFacilitiesDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, EVACUATION_FACILITIES);
            evacuationFacilitiesDataFragment.setViewModel(
                    (EvacuationFacilitiesDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, EVACUATION_FACILITIES, repositoryManager, appContext));
            mAdapter.addFragment(evacuationFacilitiesDataFragment);
        }

        {
            // Setup wash data fragment
            EvacuationWashDataFragment evacuationWashDataFragment =
                    (EvacuationWashDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, EVACUATION_WASH);
            evacuationWashDataFragment.setViewModel(
                    (EvacuationWashDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, EVACUATION_WASH, repositoryManager, appContext));
            mAdapter.addFragment(evacuationWashDataFragment);
        }

        {
            // Setup security data fragment
            EvacuationSecurityDataFragment evacuationSecurityDataFragment =
                    (EvacuationSecurityDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, EVACUATION_SECURITY);
            evacuationSecurityDataFragment.setViewModel(
                    (EvacuationSecurityDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, EVACUATION_SECURITY, repositoryManager, appContext));
            mAdapter.addFragment(evacuationSecurityDataFragment);
        }

        {
            // Setup coping data fragment
            EvacuationCopingDataFragment evacuationCopingDataFragment = 
                    (EvacuationCopingDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, EVACUATION_COPING);
            evacuationCopingDataFragment.setViewModel(
                    (EvacuationCopingDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, EVACUATION_COPING, repositoryManager, appContext));
            mAdapter.addFragment(evacuationCopingDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

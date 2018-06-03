package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationSiteData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataViewModel;
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

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

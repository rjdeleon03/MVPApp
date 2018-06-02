package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;

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

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

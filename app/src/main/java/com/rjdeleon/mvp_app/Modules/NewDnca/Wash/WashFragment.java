package com.rjdeleon.mvp_app.Modules.NewDnca.Wash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WashFragment extends BaseMultiPageFragment {

    public static final String WASH_CONDITIONS_VIEWMODEL_TAG = "WASH_CONDITIONS_VIEWMODEL_TAG";

    public static WashFragment newInstance() {
        return new WashFragment();
    }

    public WashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        // Setup specific repository manager
        WashRepositoryManager repositoryManager = (WashRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

}

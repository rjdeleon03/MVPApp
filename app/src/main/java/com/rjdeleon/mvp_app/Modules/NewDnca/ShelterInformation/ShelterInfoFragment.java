package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData.HouseDamageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData.HouseDamageViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterInfoFragment extends BaseMultiPageFragment {

    public static final String SHELTER_INFO_HOUSE_DAMAGE_VIEWMODEL_TAG = "SHELTER_INFO_HOUSE_DAMAGE_VIEWMODEL_TAG";

    public static ShelterInfoFragment newInstance() {
        return new ShelterInfoFragment();
    }

    public ShelterInfoFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        // Setup specific repository manager
        ShelterInfoRepositoryManager repositoryManager = (ShelterInfoRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup house damage data fragment
            HouseDamageFragment houseDamageFragment = HouseDamageFragment.newInstance();
            HouseDamageViewModel calamityDetailsViewModel = new HouseDamageViewModel(getContext().getApplicationContext(), repositoryManager);
            houseDamageFragment.setViewModel(calamityDetailsViewModel);
            mAdapter.addFragment(houseDamageFragment);

            // Bind calamity details viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(calamityDetailsViewModel),
                    SHELTER_INFO_HOUSE_DAMAGE_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodCopingData.FoodCopingDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodCopingData.FoodCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodSecurityFragment extends BaseMultiPageFragment {

    public static final String FOOD_SECURITY_IMPACT_VIEWMODEL_TAG = "FOOD_SECURITY_IMPACT_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_COPING_VIEWMODEL_TAG = "FOOD_SECURITY_COPING_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_NEEDS_VIEWMODEL_TAG = "FOOD_SECURITY_NEEDS_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_GAPS_VIEWMODEL_TAG = "FOOD_SECURITY_GAPS_VIEWMODEL_TAG";

    public static FoodSecurityFragment newInstance() {
        return new FoodSecurityFragment();
    }

    public FoodSecurityFragment() {
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
        FoodSecurityRepositoryManager repositoryManager = (FoodSecurityRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup food impact data fragment
            FoodImpactDataFragment foodImpactDataFragment = FoodImpactDataFragment.newInstance();
            FoodImpactDataViewModel foodImpactDataViewModel = new FoodImpactDataViewModel(getContext().getApplicationContext(), repositoryManager);
            foodImpactDataFragment.setViewModel(foodImpactDataViewModel);
            mAdapter.addFragment(foodImpactDataFragment);

            // Bind food impact data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(foodImpactDataViewModel),
                    FOOD_SECURITY_IMPACT_VIEWMODEL_TAG);
        }

        {
            // Setup food coping data fragment
            FoodCopingDataFragment foodCopingDataFragment = FoodCopingDataFragment.newInstance();
            FoodCopingDataViewModel foodCopingDataViewModel = new FoodCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
            foodCopingDataFragment.setViewModel(foodCopingDataViewModel);
            mAdapter.addFragment(foodCopingDataFragment);

            // Bind food coping data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(foodCopingDataViewModel),
                    FOOD_SECURITY_COPING_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

package com.cpu.quikdata.Modules.NewDnca.FoodSecurity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodAssistanceData.FoodAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodCopingData.FoodCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodCopingData.FoodCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodGapsData.FoodGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodGapsData.FoodGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodNeedsData.FoodNeedsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodNeedsData.FoodNeedsDataViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_ASSISTANCE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_GAPS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_IMPACT;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.FOOD_NEEDS;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodSecurityFragment extends BaseMultiPageFragment {

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

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        FoodSecurityRepositoryManager repositoryManager = (FoodSecurityRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup impact data fragment
            FoodImpactDataFragment foodImpactDataFragment =
                    (FoodImpactDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FOOD_IMPACT);
            foodImpactDataFragment.setViewModel(
                    (FoodImpactDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, FOOD_IMPACT, repositoryManager, appContext));
            mAdapter.addFragment(foodImpactDataFragment);
        }

        {
            // Setup coping data fragment
            FoodCopingDataFragment foodCopingDataFragment =
                    (FoodCopingDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FOOD_COPING);
            foodCopingDataFragment.setViewModel(
                    (FoodCopingDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, FOOD_COPING, repositoryManager, appContext));
            mAdapter.addFragment(foodCopingDataFragment);
        }

        {
            // Setup needs data fragment
            FoodNeedsDataFragment foodNeedsDataFragment =
                    (FoodNeedsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FOOD_NEEDS);
            foodNeedsDataFragment.setViewModel(
                    (FoodNeedsDataViewModel)  ViewFactory.findOrCreateViewModel(fragmentManager, FOOD_NEEDS, repositoryManager, appContext));
            mAdapter.addFragment(foodNeedsDataFragment);
        }

        {
            // Setup assistance data fragment
            FoodAssistanceDataFragment foodAssistanceDataFragment =
                    (FoodAssistanceDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FOOD_ASSISTANCE);
            foodAssistanceDataFragment.setViewModel(
                    (AssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, FOOD_ASSISTANCE, repositoryManager, appContext));
            mAdapter.addFragment(foodAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            FoodGapsDataFragment foodGapsDataFragment =
                    (FoodGapsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FOOD_GAPS);
            foodGapsDataFragment.setViewModel(
                    (FoodGapsDataViewModel)  ViewFactory.findOrCreateViewModel(fragmentManager, FOOD_GAPS, repositoryManager, appContext));
            mAdapter.addFragment(foodGapsDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

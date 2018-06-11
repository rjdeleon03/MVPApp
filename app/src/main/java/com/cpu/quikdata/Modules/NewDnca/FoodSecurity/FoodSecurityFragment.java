package com.cpu.quikdata.Modules.NewDnca.FoodSecurity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_ASSISTANCE;
import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_COPING;
import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_GAPS;
import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_IMPACT;
import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_NEEDS;
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

        // Setup specific repository manager
        FoodSecurityRepositoryManager repositoryManager = (FoodSecurityRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup impact data fragment
            FoodImpactDataFragment foodImpactDataFragment = (FoodImpactDataFragment)findOrCreateViewFragment(FOOD_IMPACT);
            foodImpactDataFragment.setViewModel((FoodImpactDataViewModel)findOrCreateViewModel(FOOD_IMPACT));
            mAdapter.addFragment(foodImpactDataFragment);
        }

        {
            // Setup coping data fragment
            FoodCopingDataFragment foodCopingDataFragment = (FoodCopingDataFragment)findOrCreateViewFragment(FOOD_COPING);
            foodCopingDataFragment.setViewModel((FoodCopingDataViewModel)findOrCreateViewModel(FOOD_COPING));
            mAdapter.addFragment(foodCopingDataFragment);
        }

        {
            // Setup needs data fragment
            FoodNeedsDataFragment foodNeedsDataFragment = (FoodNeedsDataFragment)findOrCreateViewFragment(FOOD_NEEDS);
            foodNeedsDataFragment.setViewModel((FoodNeedsDataViewModel) findOrCreateViewModel(FOOD_NEEDS));
            mAdapter.addFragment(foodNeedsDataFragment);
        }

        {
            // Setup assistance data fragment
            FoodAssistanceDataFragment foodAssistanceDataFragment = (FoodAssistanceDataFragment)findOrCreateViewFragment(FOOD_ASSISTANCE);
            foodAssistanceDataFragment.setViewModel((AssistanceDataViewModel)findOrCreateViewModel(FOOD_ASSISTANCE));
            mAdapter.addFragment(foodAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            FoodGapsDataFragment foodGapsDataFragment = (FoodGapsDataFragment)findOrCreateViewFragment(FOOD_GAPS);
            foodGapsDataFragment.setViewModel((FoodGapsDataViewModel) findOrCreateViewModel(FOOD_GAPS));
            mAdapter.addFragment(foodGapsDataFragment);
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
    private Fragment findOrCreateViewFragment(AppConstants.FoodSecurityComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(getChildFragmentManager(), fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {
                case FOOD_IMPACT:
                    selectedFragment = FoodImpactDataFragment.newInstance();
                    break;
                case FOOD_COPING:
                    selectedFragment = FoodCopingDataFragment.newInstance();
                    break;
                case FOOD_NEEDS:
                    selectedFragment = FoodNeedsDataFragment.newInstance();
                    break;
                case FOOD_ASSISTANCE:
                    selectedFragment = FoodAssistanceDataFragment.newInstance();
                    break;
                case FOOD_GAPS:
                    selectedFragment = FoodGapsDataFragment.newInstance();
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
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.FoodSecurityComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);

        // Setup specific repository manager
        FoodSecurityRepositoryManager repositoryManager = (FoodSecurityRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case FOOD_IMPACT:
                    viewModel = new FoodImpactDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case FOOD_COPING:
                    viewModel = new FoodCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case FOOD_NEEDS:
                    viewModel = new FoodNeedsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case FOOD_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case FOOD_GAPS:
                    viewModel = new FoodGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }

}

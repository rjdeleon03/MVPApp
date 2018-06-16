package com.cpu.quikdata.Modules.NewDnca.Wash;

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
import com.cpu.quikdata.Modules.NewDnca.Wash.WashAssistanceData.WashAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.WASH_ASSISTANCE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.WASH_CONDITIONS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.WASH_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.WASH_GAPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class WashFragment extends BaseMultiPageFragment {

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

        {
            // Setup wash conditions fragment
            WashConditionsFragment washConditionsFragment = (WashConditionsFragment)findOrCreateViewFragment(WASH_CONDITIONS);
            washConditionsFragment.setViewModel((WashConditionsViewModel)findOrCreateViewModel(WASH_CONDITIONS));
            mAdapter.addFragment(washConditionsFragment);
        }

        {
            // Setup coping data fragment
            WashCopingDataFragment washCopingDataFragment = (WashCopingDataFragment)findOrCreateViewFragment(WASH_COPING);
            washCopingDataFragment.setViewModel((WashCopingDataViewModel)findOrCreateViewModel(WASH_COPING));
            mAdapter.addFragment(washCopingDataFragment);
        }

        {
            // Setup assistance data fragment
            WashAssistanceDataFragment washAssistanceDataFragment = (WashAssistanceDataFragment)findOrCreateViewFragment(WASH_ASSISTANCE);
            washAssistanceDataFragment.setViewModel((AssistanceDataViewModel)findOrCreateViewModel(WASH_ASSISTANCE));
            mAdapter.addFragment(washAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            WashGapsDataFragment washGapsDataFragment = (WashGapsDataFragment)findOrCreateViewFragment(WASH_GAPS);
            washGapsDataFragment.setViewModel((WashGapsDataViewModel)findOrCreateViewModel(WASH_GAPS));
            mAdapter.addFragment(washGapsDataFragment);
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
    private Fragment findOrCreateViewFragment(AppConstants.NewDncaComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(getChildFragmentManager(), fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {
                case WASH_CONDITIONS:
                    selectedFragment = WashConditionsFragment.newInstance();
                    break;
                case WASH_COPING:
                    selectedFragment = WashCopingDataFragment.newInstance();
                    break;
                case WASH_ASSISTANCE:
                    selectedFragment = WashAssistanceDataFragment.newInstance();
                    break;
                case WASH_GAPS:
                    selectedFragment = WashGapsDataFragment.newInstance();
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
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.NewDncaComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);

        // Setup specific repository manager
        WashRepositoryManager repositoryManager = (WashRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case WASH_CONDITIONS:
                    viewModel = new WashConditionsViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case WASH_COPING:
                    viewModel = new WashCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case WASH_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case WASH_GAPS:
                    viewModel = new WashGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }

}

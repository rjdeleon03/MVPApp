package com.cpu.quikdata.Modules.NewDnca.Wash;

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
import com.cpu.quikdata.Modules.NewDnca.Wash.WashAssistanceData.WashAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
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

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        WashRepositoryManager repositoryManager = (WashRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup wash conditions fragment
            WashConditionsFragment washConditionsFragment =
                    (WashConditionsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, WASH_CONDITIONS);
            washConditionsFragment.setViewModel(
                    (WashConditionsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, WASH_CONDITIONS, repositoryManager, appContext));
            mAdapter.addFragment(washConditionsFragment);
        }

        {
            // Setup coping data fragment
            WashCopingDataFragment washCopingDataFragment =
                    (WashCopingDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, WASH_COPING);
            washCopingDataFragment.setViewModel(
                    (WashCopingDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, WASH_COPING, repositoryManager, appContext));
            mAdapter.addFragment(washCopingDataFragment);
        }

        {
            // Setup assistance data fragment
            WashAssistanceDataFragment washAssistanceDataFragment =
                    (WashAssistanceDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, WASH_ASSISTANCE);
            washAssistanceDataFragment.setViewModel(
                    (AssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, WASH_ASSISTANCE, repositoryManager, appContext));
            mAdapter.addFragment(washAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            WashGapsDataFragment washGapsDataFragment =
                    (WashGapsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, WASH_GAPS);
            washGapsDataFragment.setViewModel(
                    (WashGapsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, WASH_GAPS, repositoryManager, appContext));
            mAdapter.addFragment(washGapsDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);
        
        return root;
    }
}

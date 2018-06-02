package com.rjdeleon.mvp_app.Modules.NewDnca.Wash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.WashConditionsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashCopingData.WashCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashGapsData.WashGapsDataViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WashFragment extends BaseMultiPageFragment {

    public static final String WASH_CONDITIONS_VIEWMODEL_TAG = "WASH_CONDITIONS_VIEWMODEL_TAG";
    public static final String WASH_COPING_VIEWMODEL_TAG = "WASH_COPING_VIEWMODEL_TAG";
    public static final String WASH_ASSISTANCE_VIEWMODEL_TAG = "WASH_GAPS_VIEWMODEL_TAG";
    public static final String WASH_GAPS_VIEWMODEL_TAG = "WASH_GAPS_VIEWMODEL_TAG";

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
            BaseQuestionFragment washConditionsFragment =  BaseQuestionFragment.newInstance();
            WashConditionsViewModel washConditionsViewModel = new  WashConditionsViewModel(getContext().getApplicationContext(), repositoryManager);
            washConditionsFragment.setViewModel(washConditionsViewModel);
            mAdapter.addFragment( washConditionsFragment);

            // Bind wash conditions viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(washConditionsViewModel),
                    WASH_CONDITIONS_VIEWMODEL_TAG);
        }

        {
            // Setup coping data fragment
            BaseQuestionFragment washCopingDataFragment =  BaseQuestionFragment.newInstance();
            WashCopingDataViewModel washCopingDataViewModel = new  WashCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
            washCopingDataFragment.setViewModel(washCopingDataViewModel);
            mAdapter.addFragment( washCopingDataFragment);

            // Bind coping data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(washCopingDataViewModel),
                    WASH_COPING_VIEWMODEL_TAG);
        }

        {
            // Setup assistance data fragment
            AssistanceDataFragment assistanceDataFragment = AssistanceDataFragment.newInstance();
            AssistanceDataViewModel assistanceDataViewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
            assistanceDataFragment.setViewModel(assistanceDataViewModel);
            mAdapter.addFragment(assistanceDataFragment);

            // Bind assistance data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(assistanceDataViewModel),
                    WASH_ASSISTANCE_VIEWMODEL_TAG);
        }

        {
            // Setup gaps data fragment
            BaseQuestionFragment washGapsDataFragment =  BaseQuestionFragment.newInstance();
            WashGapsDataViewModel washGapsDataViewModel = new  WashGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
            washGapsDataFragment.setViewModel(washGapsDataViewModel);
            mAdapter.addFragment( washGapsDataFragment);

            // Bind gaps data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(washGapsDataViewModel),
                    WASH_GAPS_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);
        
        return root;
    }

}

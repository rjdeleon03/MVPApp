package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsCopingData.LivelihoodsCopingDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsCopingData.LivelihoodsCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsGapsData.LivelihoodsGapsDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsGapsData.LivelihoodsGapsDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.IncomeBeforeFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.IncomeBeforeViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData.LivelihoodsNeedsDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData.LivelihoodsNeedsDataViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsFragment extends BaseMultiPageFragment {
    
    public static final String LIVELIHOODS_INCOME_BEFORE_VIEWMODEL_TAG = "LIVELIHOODS_INCOME_BEFORE_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_INCOME_AFTER_VIEWMODEL_TAG = "LIVELIHOODS_INCOME_AFTER_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_DAMAGE_VIEWMODEL_TAG = "LIVELIHOODS_DAMAGE_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_COPING_VIEWMODEL_TAG = "LIVELIHOODS_COPING_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_NEEDS_VIEWMODEL_TAG = "LIVELIHOODS_NEEDS_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_ASSISTANCE_VIEWMODEL_TAG = "LIVELIHOODS_ASSISTANCE_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_GAPS_VIEWMODEL_TAG = "LIVELIHOODS_GAPS_VIEWMODEL_TAG";

    public static LivelihoodsFragment newInstance() {
        return new LivelihoodsFragment();
    }

    public LivelihoodsFragment() {
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
        LivelihoodsRepositoryManager repositoryManager = (LivelihoodsRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup income before emergency fragment
            IncomeBeforeFragment incomeBeforeFragment = IncomeBeforeFragment.newInstance();
            IncomeBeforeViewModel incomeBeforeViewModel = new IncomeBeforeViewModel(getContext().getApplicationContext(), repositoryManager, true);
            incomeBeforeFragment.setViewModel(incomeBeforeViewModel);
            mAdapter.addFragment(incomeBeforeFragment);

            // Bind income before emergency viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(incomeBeforeViewModel),
                    LIVELIHOODS_INCOME_BEFORE_VIEWMODEL_TAG);
        }

        {
            // Setup income after emergency fragment
            IncomeBeforeFragment incomeBeforeFragment = IncomeBeforeFragment.newInstance();
            IncomeBeforeViewModel incomeBeforeViewModel = new IncomeBeforeViewModel(getContext().getApplicationContext(), repositoryManager, false);
            incomeBeforeFragment.setViewModel(incomeBeforeViewModel);
            mAdapter.addFragment(incomeBeforeFragment);

            // Bind income after emergency viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(incomeBeforeViewModel),
                    LIVELIHOODS_INCOME_AFTER_VIEWMODEL_TAG);
        }

        {
            // Setup damage data fragment
            LivelihoodsDamageFragment livelihoodsDamageFragment = LivelihoodsDamageFragment.newInstance();
            LivelihoodsDamageViewModel livelihoodsDamageViewModel = new LivelihoodsDamageViewModel(getContext().getApplicationContext(), repositoryManager);
            livelihoodsDamageFragment.setViewModel(livelihoodsDamageViewModel);
            mAdapter.addFragment(livelihoodsDamageFragment);

            // Bind damage data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(livelihoodsDamageViewModel),
                    LIVELIHOODS_DAMAGE_VIEWMODEL_TAG);
        }

        {
            // Setup coping data fragment
            LivelihoodsCopingDataFragment livelihoodsCopingDataFragment = LivelihoodsCopingDataFragment.newInstance();
            LivelihoodsCopingDataViewModel livelihoodsCopingDataViewModel = new LivelihoodsCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
            livelihoodsCopingDataFragment.setViewModel(livelihoodsCopingDataViewModel);
            mAdapter.addFragment(livelihoodsCopingDataFragment);

            // Bind coping data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(livelihoodsCopingDataViewModel),
                    LIVELIHOODS_COPING_VIEWMODEL_TAG);
        }

        {
            // Setup needs data fragment
            LivelihoodsNeedsDataFragment livelihoodsNeedsDataFragment = LivelihoodsNeedsDataFragment.newInstance();
            LivelihoodsNeedsDataViewModel livelihoodsNeedsDataViewModel = new LivelihoodsNeedsDataViewModel(getContext().getApplicationContext(), repositoryManager);
            livelihoodsNeedsDataFragment.setViewModel(livelihoodsNeedsDataViewModel);
            mAdapter.addFragment(livelihoodsNeedsDataFragment);

            // Bind needs data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(livelihoodsNeedsDataViewModel),
                    LIVELIHOODS_NEEDS_VIEWMODEL_TAG);
        }

        {
            // Setup food assistance data fragment
            AssistanceDataFragment assistanceDataFragment = AssistanceDataFragment.newInstance();
            AssistanceDataViewModel assistanceDataViewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
            assistanceDataFragment.setViewModel(assistanceDataViewModel);
            mAdapter.addFragment(assistanceDataFragment);

            // Bind food assistance data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(assistanceDataViewModel),
                    LIVELIHOODS_ASSISTANCE_VIEWMODEL_TAG);
        }

        {
            // Setup gaps data fragment
            LivelihoodsGapsDataFragment livelihoodsGapsDataFragment = LivelihoodsGapsDataFragment.newInstance();
            LivelihoodsGapsDataViewModel livelihoodsGapsDataViewModel = new LivelihoodsGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
            livelihoodsGapsDataFragment.setViewModel(livelihoodsGapsDataViewModel);
            mAdapter.addFragment(livelihoodsGapsDataFragment);

            // Bind gaps data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(livelihoodsGapsDataViewModel),
                    LIVELIHOODS_GAPS_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

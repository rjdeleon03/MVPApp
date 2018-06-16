package com.cpu.quikdata.Modules.NewDnca.Livelihoods;

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
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsAssistanceData.LivelihoodsAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsCopingData.LivelihoodsCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsCopingData.LivelihoodsCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsGapsData.LivelihoodsGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsGapsData.LivelihoodsGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeAfterFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeBeforeFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData.LivelihoodsNeedsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData.LivelihoodsNeedsDataViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_ASSISTANCE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_DAMAGE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_GAPS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_INCOME_AFTER;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_INCOME_BEFORE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_NEEDS;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsFragment extends BaseMultiPageFragment {

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

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        LivelihoodsRepositoryManager repositoryManager = (LivelihoodsRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup income before emergency fragment
            LivelihoodsIncomeBeforeFragment livelihoodsIncomeFragment =
                    (LivelihoodsIncomeBeforeFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_INCOME_BEFORE);
            livelihoodsIncomeFragment.setViewModel(
                    (LivelihoodsIncomeViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_INCOME_BEFORE, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsIncomeFragment);
        }

        {
            // Setup income after emergency fragment
            LivelihoodsIncomeAfterFragment livelihoodsIncomeFragment =
                    (LivelihoodsIncomeAfterFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_INCOME_AFTER);
            livelihoodsIncomeFragment.setViewModel(
                    (LivelihoodsIncomeViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_INCOME_AFTER, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsIncomeFragment);
        }

        {
            // Setup damage data fragment
            LivelihoodsDamageFragment livelihoodsDamageFragment =
                    (LivelihoodsDamageFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_DAMAGE);
            livelihoodsDamageFragment.setViewModel(
                    (LivelihoodsDamageViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_DAMAGE, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsDamageFragment);
        }

        {
            // Setup coping data fragment
            LivelihoodsCopingDataFragment livelihoodsCopingDataFragment =
                    (LivelihoodsCopingDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_COPING);
            livelihoodsCopingDataFragment.setViewModel(
                    (LivelihoodsCopingDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_COPING, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsCopingDataFragment);
        }

        {
            // Setup needs data fragment
            LivelihoodsNeedsDataFragment livelihoodsNeedsDataFragment =
                    (LivelihoodsNeedsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_NEEDS);
            livelihoodsNeedsDataFragment.setViewModel(
                    (LivelihoodsNeedsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_NEEDS, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsNeedsDataFragment);
        }

        {
            // Setup food assistance data fragment
            LivelihoodsAssistanceDataFragment livelihoodsAssistanceDataFragment =
                    (LivelihoodsAssistanceDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_ASSISTANCE);
            livelihoodsAssistanceDataFragment.setViewModel(
                    (AssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_ASSISTANCE, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            LivelihoodsGapsDataFragment livelihoodsGapsDataFragment =
                    (LivelihoodsGapsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, LIVELIHOODS_GAPS);
            livelihoodsGapsDataFragment.setViewModel(
                    (LivelihoodsGapsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, LIVELIHOODS_GAPS, repositoryManager, appContext));
            mAdapter.addFragment(livelihoodsGapsDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

package com.cpu.quikdata.Modules.NewDnca.Livelihoods;

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

        // Setup specific repository manager
        LivelihoodsRepositoryManager repositoryManager = (LivelihoodsRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup income before emergency fragment
            LivelihoodsIncomeBeforeFragment livelihoodsIncomeFragment = (LivelihoodsIncomeBeforeFragment)findOrCreateViewFragment(LIVELIHOODS_INCOME_BEFORE);
            livelihoodsIncomeFragment.setViewModel((LivelihoodsIncomeViewModel)findOrCreateViewModel(LIVELIHOODS_INCOME_BEFORE));
            mAdapter.addFragment(livelihoodsIncomeFragment);
        }

        {
            // Setup income after emergency fragment
            LivelihoodsIncomeAfterFragment livelihoodsIncomeFragment = (LivelihoodsIncomeAfterFragment)findOrCreateViewFragment(LIVELIHOODS_INCOME_AFTER);
            livelihoodsIncomeFragment.setViewModel((LivelihoodsIncomeViewModel)findOrCreateViewModel(LIVELIHOODS_INCOME_AFTER));
            mAdapter.addFragment(livelihoodsIncomeFragment);
        }

        {
            // Setup damage data fragment
            LivelihoodsDamageFragment livelihoodsDamageFragment = (LivelihoodsDamageFragment)findOrCreateViewFragment(LIVELIHOODS_DAMAGE);
            livelihoodsDamageFragment.setViewModel((LivelihoodsDamageViewModel)findOrCreateViewModel(LIVELIHOODS_DAMAGE));
            mAdapter.addFragment(livelihoodsDamageFragment);
        }

        {
            // Setup coping data fragment
            LivelihoodsCopingDataFragment livelihoodsCopingDataFragment = (LivelihoodsCopingDataFragment)findOrCreateViewFragment(LIVELIHOODS_COPING);
            livelihoodsCopingDataFragment.setViewModel((LivelihoodsCopingDataViewModel)findOrCreateViewModel(LIVELIHOODS_COPING));
            mAdapter.addFragment(livelihoodsCopingDataFragment);
        }

        {
            // Setup needs data fragment
            LivelihoodsNeedsDataFragment livelihoodsNeedsDataFragment = (LivelihoodsNeedsDataFragment)findOrCreateViewFragment(LIVELIHOODS_NEEDS);
            livelihoodsNeedsDataFragment.setViewModel((LivelihoodsNeedsDataViewModel)findOrCreateViewModel(LIVELIHOODS_NEEDS));
            mAdapter.addFragment(livelihoodsNeedsDataFragment);
        }

        {
            // Setup food assistance data fragment
            LivelihoodsAssistanceDataFragment livelihoodsAssistanceDataFragment = (LivelihoodsAssistanceDataFragment)findOrCreateViewFragment(LIVELIHOODS_ASSISTANCE);
            livelihoodsAssistanceDataFragment.setViewModel((AssistanceDataViewModel)findOrCreateViewModel(LIVELIHOODS_ASSISTANCE));
            mAdapter.addFragment(livelihoodsAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            LivelihoodsGapsDataFragment livelihoodsGapsDataFragment = (LivelihoodsGapsDataFragment)findOrCreateViewFragment(LIVELIHOODS_GAPS);
            livelihoodsGapsDataFragment.setViewModel((LivelihoodsGapsDataViewModel)findOrCreateViewModel(LIVELIHOODS_GAPS));
            mAdapter.addFragment(livelihoodsGapsDataFragment);
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
                case LIVELIHOODS_INCOME_BEFORE:
                    selectedFragment = LivelihoodsIncomeBeforeFragment.newInstance();
                    break;
                case LIVELIHOODS_INCOME_AFTER:
                    selectedFragment = LivelihoodsIncomeAfterFragment.newInstance();
                    break;
                case LIVELIHOODS_DAMAGE:
                    selectedFragment = LivelihoodsDamageFragment.newInstance();
                    break;
                case LIVELIHOODS_COPING:
                    selectedFragment = LivelihoodsCopingDataFragment.newInstance();
                    break;
                case LIVELIHOODS_NEEDS:
                    selectedFragment = LivelihoodsNeedsDataFragment.newInstance();
                    break;
                case LIVELIHOODS_ASSISTANCE:
                    selectedFragment = LivelihoodsAssistanceDataFragment.newInstance();
                    break;
                case LIVELIHOODS_GAPS:
                    selectedFragment = LivelihoodsGapsDataFragment.newInstance();
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
        LivelihoodsRepositoryManager repositoryManager = (LivelihoodsRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case LIVELIHOODS_INCOME_BEFORE:
                    viewModel = new LivelihoodsIncomeViewModel(getContext().getApplicationContext(), repositoryManager, true);
                    break;
                case LIVELIHOODS_INCOME_AFTER:
                    viewModel = new LivelihoodsIncomeViewModel(getContext().getApplicationContext(), repositoryManager, false);
                    break;
                case LIVELIHOODS_DAMAGE:
                    viewModel = new LivelihoodsDamageViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case LIVELIHOODS_COPING:
                    viewModel = new LivelihoodsCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case LIVELIHOODS_NEEDS:
                    viewModel = new LivelihoodsNeedsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case LIVELIHOODS_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case LIVELIHOODS_GAPS:
                    viewModel = new LivelihoodsGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

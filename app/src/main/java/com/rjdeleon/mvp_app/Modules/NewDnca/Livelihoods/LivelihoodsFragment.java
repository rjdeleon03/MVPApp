package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.DamageCostFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.DamageCostViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.IncomeBeforeFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.IncomeBeforeViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsFragment extends BaseMultiPageFragment {
    
    public static final String LIVELIHOODS_INCOME_BEFORE_VIEWMODEL_TAG = "LIVELIHOODS_INCOME_BEFORE_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_INCOME_AFTER_VIEWMODEL_TAG = "LIVELIHOODS_INCOME_AFTER_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_DAMAGE_VIEWMODEL_TAG = "LIVELIHOODS_DAMAGE_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_COPING_AFTER_VIEWMODEL_TAG = "LIVELIHOODS_COPING_AFTER_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_NEEDS_AFTER_VIEWMODEL_TAG = "LIVELIHOODS_NEEDS_AFTER_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_ASSISTANCE_AFTER_VIEWMODEL_TAG = "LIVELIHOODS_ASSISTANCE_AFTER_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_GAPS_AFTER_VIEWMODEL_TAG = "LIVELIHOODS_GAPS_AFTER_VIEWMODEL_TAG";

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
            IncomeBeforeViewModel incomeBeforeViewModel = new IncomeBeforeViewModel(getContext().getApplicationContext(), repositoryManager);
            incomeBeforeFragment.setViewModel(incomeBeforeViewModel);
            mAdapter.addFragment(incomeBeforeFragment);

            // Bind income before emergency viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(incomeBeforeViewModel),
                    LIVELIHOODS_INCOME_BEFORE_VIEWMODEL_TAG);
        }

        {
            // Setup damage data fragment
            DamageCostFragment damageCostFragment = DamageCostFragment.newInstance();
            DamageCostViewModel damageCostViewModel = new DamageCostViewModel(getContext().getApplicationContext(), repositoryManager);
            damageCostFragment.setViewModel(damageCostViewModel);
            mAdapter.addFragment(damageCostFragment);

            // Bind damage data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(damageCostViewModel),
                    LIVELIHOODS_DAMAGE_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

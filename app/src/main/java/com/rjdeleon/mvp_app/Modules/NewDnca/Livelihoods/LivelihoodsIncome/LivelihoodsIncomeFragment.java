package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.LivelihoodsIncomeDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.LivelihoodsIncomeDialogViewModel;

public class LivelihoodsIncomeFragment extends BaseEnumFragment {

    private LivelihoodsIncomeFragmentAdapter mLivelihoodsIncomeFragmentAdapter;

    public static LivelihoodsIncomeFragment newInstance() {
        return new LivelihoodsIncomeFragment();
    }

    public LivelihoodsIncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsIncomeDialogViewModel dialogViewModel = new LivelihoodsIncomeDialogViewModel(
                getContext(),
                (LivelihoodsIncomeRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = LivelihoodsIncomeDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsIncomeDialogViewModel dialogViewModel = new LivelihoodsIncomeDialogViewModel(
                getContext(),
                (LivelihoodsIncomeRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = LivelihoodsIncomeDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mLivelihoodsIncomeFragmentAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mLivelihoodsIncomeFragmentAdapter = new LivelihoodsIncomeFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (LivelihoodsIncomeViewModel) mViewModel);
        mRowRecycler.setAdapter(mLivelihoodsIncomeFragmentAdapter);
    }
}
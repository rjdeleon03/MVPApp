package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.LivelihoodsIncomeDialogFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.LivelihoodsIncomeDialogViewModel;

import static com.cpu.quikdata.AppConstants.FoodSecurityComponent.FOOD_GAPS;

public abstract class LivelihoodsIncomeFragment extends BaseEnumFragment {

    private LivelihoodsIncomeFragmentAdapter mLivelihoodsIncomeFragmentAdapter;

    public LivelihoodsIncomeFragment() {
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
        mDialogFragment = LivelihoodsIncomeDialogFragment.newInstance();
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
        mDialogFragment = LivelihoodsIncomeDialogFragment.newInstance();
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

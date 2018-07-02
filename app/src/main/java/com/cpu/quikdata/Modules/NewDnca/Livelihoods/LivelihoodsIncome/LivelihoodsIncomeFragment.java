package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.view.View;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsIncomeDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumNoTypeRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.LivelihoodsIncomeDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row.LivelihoodsIncomeRowViewModel;

public abstract class LivelihoodsIncomeFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<LivelihoodsIncomeRowViewModel> mLivelihoodsIncomeFragmentAdapter;

    public LivelihoodsIncomeFragment() {
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsIncomeDialogViewModel dialogViewModel = new LivelihoodsIncomeDialogViewModel(
                (BaseEnumNoTypeRepositoryManager<LivelihoodsIncomeDataRow, GenericEnumDataRow.IncomeSourceType>) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsIncomeDialogViewModel dialogViewModel = new LivelihoodsIncomeDialogViewModel(
                (BaseEnumNoTypeRepositoryManager<LivelihoodsIncomeDataRow, GenericEnumDataRow.IncomeSourceType>) mViewModel,
                rowIndex,
                false);
        super.setupDialog(dialogViewModel);
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
        mLivelihoodsIncomeFragmentAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                LivelihoodsIncomeRowViewModel.class,
                this,
                (LivelihoodsIncomeViewModel) mViewModel);
        mRowRecycler.setAdapter(mLivelihoodsIncomeFragmentAdapter);
    }
}

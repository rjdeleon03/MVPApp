package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.IncomeBeforeDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog.IncomeBeforeDialogViewModel;

public class IncomeBeforeFragment extends BaseEnumFragment {

    private IncomeBeforeFragmentAdapter mIncomeBeforeFragmentAdapter;

    public static IncomeBeforeFragment newInstance() {
        return new IncomeBeforeFragment();
    }

    public IncomeBeforeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        IncomeBeforeDialogViewModel dialogViewModel = new IncomeBeforeDialogViewModel(
                getContext(),
                (IncomeBeforeRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = IncomeBeforeDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        IncomeBeforeDialogViewModel dialogViewModel = new IncomeBeforeDialogViewModel(
                getContext(),
                (IncomeBeforeRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = IncomeBeforeDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mIncomeBeforeFragmentAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mIncomeBeforeFragmentAdapter = new IncomeBeforeFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (IncomeBeforeViewModel) mViewModel);
        mRowRecycler.setAdapter(mIncomeBeforeFragmentAdapter);
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost;

import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.DamageCostDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.DamageCostDialogViewModel;

public class DamageCostFragment extends BaseEnumFragment {

    private DamageCostFragmentAdapter mDamageCostFragmentAdapter;

    public static DamageCostFragment newInstance() {
        return new DamageCostFragment();
    }

    public DamageCostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DamageCostDialogViewModel dialogViewModel = new DamageCostDialogViewModel(
                getContext(),
                (DamageCostRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DamageCostDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");

    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        DamageCostDialogViewModel dialogViewModel = new DamageCostDialogViewModel(
                getContext(),
                (DamageCostRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DamageCostDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mDamageCostFragmentAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mDamageCostFragmentAdapter = new DamageCostFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (DamageCostViewModel) mViewModel);
        mRowRecycler.setAdapter(mDamageCostFragmentAdapter);
    }
}

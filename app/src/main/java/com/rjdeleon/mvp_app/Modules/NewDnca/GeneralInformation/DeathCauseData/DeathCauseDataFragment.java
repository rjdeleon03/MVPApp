package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;


import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog.DeathCauseDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog.DeathCauseDataDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeathCauseDataFragment extends BaseEnumFragment {

    private DeathCauseDataFragmentAdapter mDeathCauseAdapter;

    public static DeathCauseDataFragment newInstance() {
        return new DeathCauseDataFragment();
    }

    public DeathCauseDataFragment() {
        setFragmentTag(AppConstants.GenInfoComponent.DEATH_CAUSE.toString());
    }

    /**
     * Show Death Cause Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DeathCauseDataDialogViewModel dialogViewModel = new DeathCauseDataDialogViewModel(
                getContext(),
                (DeathCauseRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DeathCauseDataDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        DeathCauseDataDialogViewModel dialogViewModel = new DeathCauseDataDialogViewModel(
                getContext(),
                (DeathCauseRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DeathCauseDataDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mDeathCauseAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mDeathCauseAdapter = new DeathCauseDataFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (DeathCauseDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mDeathCauseAdapter);
    }
}

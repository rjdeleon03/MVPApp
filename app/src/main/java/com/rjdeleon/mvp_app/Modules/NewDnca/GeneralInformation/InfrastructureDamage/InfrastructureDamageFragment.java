package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;


import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseAgeGroupFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfrastructureDamageFragment extends BaseAgeGroupFragment {

    private InfrastructureDamageFragmentAdapter mInfrastructureAdapter;

    public static InfrastructureDamageFragment getInstance() {
        return new InfrastructureDamageFragment();
    }

    public InfrastructureDamageFragment() {
        // Required empty public constructor
    }

    /**
     * Show infrastructure damage data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        InfrastructureDamageDialogViewModel dialogViewModel = new InfrastructureDamageDialogViewModel(
                getContext(),
                (InfrastructureDamageRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = InfrastructureDamageDialogFragment.getInstance();
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
        InfrastructureDamageDialogViewModel dialogViewModel = new InfrastructureDamageDialogViewModel(
                getContext(),
                (InfrastructureDamageRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = InfrastructureDamageDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");

    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mInfrastructureAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mInfrastructureAdapter = new InfrastructureDamageFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (InfrastructureDamageViewModel) mViewModel);
        mRowRecycler.setAdapter(mInfrastructureAdapter);
    }
}

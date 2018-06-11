package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;


import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogViewModel;

import static com.cpu.quikdata.AppConstants.GenInfoComponent.GEN_INFO_INFRASTRUCTURE;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfrastructureDamageFragment extends BaseEnumFragment {

    private InfrastructureDamageFragmentAdapter mInfrastructureAdapter;

    public static InfrastructureDamageFragment newInstance() {
        return new InfrastructureDamageFragment();
    }

    public InfrastructureDamageFragment() {
        setFragmentTag(GEN_INFO_INFRASTRUCTURE.toString());
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
        mDialogFragment = InfrastructureDamageDialogFragment.newInstance();
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
        mDialogFragment = InfrastructureDamageDialogFragment.newInstance();
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

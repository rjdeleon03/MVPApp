package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;


import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row.InfrastructureDamageRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_INFRASTRUCTURE;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfrastructureDamageFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<InfrastructureDamageRowViewModel> mInfrastructureAdapter;

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
                (BaseEnumRepositoryManager<InfrastructureDamageDataRow, GenericEnumDataRow.InfraType>) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        InfrastructureDamageDialogViewModel dialogViewModel = new InfrastructureDamageDialogViewModel(
                (BaseEnumRepositoryManager<InfrastructureDamageDataRow, GenericEnumDataRow.InfraType>) mViewModel,
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
        mInfrastructureAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mInfrastructureAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                InfrastructureDamageRowViewModel.class,
                this,
                (InfrastructureDamageViewModel) mViewModel);
        mRowRecycler.setAdapter(mInfrastructureAdapter);
    }
}

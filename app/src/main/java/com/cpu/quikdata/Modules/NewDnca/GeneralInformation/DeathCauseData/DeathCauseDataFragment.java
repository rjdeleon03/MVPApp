package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData;


import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.GeneralInformation.DeathCauseDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog.DeathCauseDataDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Row.DeathCauseDataRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_DEATH_CAUSE;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeathCauseDataFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<DeathCauseDataRowViewModel> mDeathCauseAdapter;

    public static DeathCauseDataFragment newInstance() {
        return new DeathCauseDataFragment();
    }

    public DeathCauseDataFragment() {
        setFragmentTag(GEN_INFO_DEATH_CAUSE.toString());
    }

    /**
     * Show Death Cause Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DeathCauseDataDialogViewModel dialogViewModel = new DeathCauseDataDialogViewModel(
                (BaseEnumRepositoryManager<DeathCauseDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        DeathCauseDataDialogViewModel dialogViewModel = new DeathCauseDataDialogViewModel(
                (BaseEnumRepositoryManager<DeathCauseDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        mDeathCauseAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mDeathCauseAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                DeathCauseDataRowViewModel.class,
                this,
                (DeathCauseDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mDeathCauseAdapter);
    }
}

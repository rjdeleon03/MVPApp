package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;


import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog.CasualtiesDataDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_CASUALTIES;

/**
 * A simple {@link Fragment} subclass.
 */
public class CasualtiesDataFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<CasualtiesDataRowViewModel> mCasualtiesDataAdapter;

    public static CasualtiesDataFragment newInstance() {
        return new CasualtiesDataFragment();
    }

    public CasualtiesDataFragment() {
        setFragmentTag(GEN_INFO_CASUALTIES.toString());
    }

    /**
     * Show Casualties Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        CasualtiesDataDialogViewModel dialogViewModel = new CasualtiesDataDialogViewModel(
                (BaseEnumRepositoryManager<CasualtiesDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        CasualtiesDataDialogViewModel dialogViewModel = new CasualtiesDataDialogViewModel(
                (BaseEnumRepositoryManager<CasualtiesDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        mCasualtiesDataAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mCasualtiesDataAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                CasualtiesDataRowViewModel.class,
                this,
                (CasualtiesDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mCasualtiesDataAdapter);
    }
}

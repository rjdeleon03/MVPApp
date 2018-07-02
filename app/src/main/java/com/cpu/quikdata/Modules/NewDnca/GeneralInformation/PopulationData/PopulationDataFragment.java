package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData;


import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.GEN_INFO_POPULATION;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopulationDataFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<PopulationDataRowViewModel> mPopulationDataAdapter;

    public static PopulationDataFragment newInstance() {
        return new PopulationDataFragment();
    }

    public PopulationDataFragment() {
        setFragmentTag(GEN_INFO_POPULATION.toString());
    }

    /**
     * Show population data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        PopulationDataDialogViewModel dialogViewModel = new PopulationDataDialogViewModel(
                (BaseEnumRepositoryManager< PopulationDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        PopulationDataDialogViewModel dialogViewModel = new PopulationDataDialogViewModel(
                (BaseEnumRepositoryManager< PopulationDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        mPopulationDataAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mPopulationDataAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                PopulationDataRowViewModel.class,
                this,
                (PopulationDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mPopulationDataAdapter);
    }
}

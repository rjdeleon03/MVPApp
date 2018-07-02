package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.Dialog.EvacuationPopulationDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.Row.EvacuationPopulationRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_POPULATION;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationPopulationFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<EvacuationPopulationRowViewModel> mEvacuationPopulationAdapter;

    public static EvacuationPopulationFragment newInstance() {
        return new EvacuationPopulationFragment();
    }

    /**
     * Show evacuation population data dialog when add button is pressed
     */
    public EvacuationPopulationFragment() {
        setFragmentTag(EVACUATION_POPULATION.toString());
    }

    /**
     * Show evacuation population data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        EvacuationPopulationDialogViewModel dialogViewModel = new EvacuationPopulationDialogViewModel(
                (BaseEnumRepositoryManager<EvacuationPopulationDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        EvacuationPopulationDialogViewModel dialogViewModel = new EvacuationPopulationDialogViewModel(
                (BaseEnumRepositoryManager<EvacuationPopulationDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        mEvacuationPopulationAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mEvacuationPopulationAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                EvacuationPopulationRowViewModel.class,
                this,
                (EvacuationPopulationViewModel) mViewModel);
        mRowRecycler.setAdapter(mEvacuationPopulationAdapter);
    }
}

package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Dialog.EvacuationPopulationDialogFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Dialog.EvacuationPopulationDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_POPULATION;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationPopulationFragment extends BaseEnumFragment {

    private EvacuationPopulationFragmentAdapter mEvacuationPopulationAdapter;

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
                getContext(),
                (EvacuationPopulationRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = EvacuationPopulationDialogFragment.newInstance();
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
        EvacuationPopulationDialogViewModel dialogViewModel = new EvacuationPopulationDialogViewModel(
                getContext(),
                (EvacuationPopulationRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = EvacuationPopulationDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
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
        mEvacuationPopulationAdapter = new EvacuationPopulationFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (EvacuationPopulationViewModel) mViewModel);
        mRowRecycler.setAdapter(mEvacuationPopulationAdapter);
    }
}

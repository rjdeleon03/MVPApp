package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;


import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopulationDataFragment extends BaseEnumFragment {

    private PopulationDataFragmentAdapter mPopulationDataAdapter;

    public static PopulationDataFragment newInstance() {
        return new PopulationDataFragment();
    }

    public PopulationDataFragment() {
        // Required empty public constructor
    }

    /**
     * Show Population Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        PopulationDataDialogViewModel dialogViewModel = new PopulationDataDialogViewModel(
                getContext(),
                (PopulationDataRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = PopulationDataDialogFragment.getInstance();
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
        PopulationDataDialogViewModel dialogViewModel = new PopulationDataDialogViewModel(
                getContext(),
                (PopulationDataRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = PopulationDataDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
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
        mPopulationDataAdapter = new PopulationDataFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (PopulationDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mPopulationDataAdapter);
    }
}

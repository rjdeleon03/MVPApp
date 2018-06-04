package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Dialog.VulnerablePopulationDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Dialog.VulnerablePopulationDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class VulnerablePopulationFragment extends BaseEnumFragment {

    private VulnerablePopulationFragmentAdapter mVulnerablePopulationAdapter;

    public static VulnerablePopulationFragment newInstance() {
        return new VulnerablePopulationFragment();
    }

    public VulnerablePopulationFragment() {
        // Required empty public constructor
    }

    /**
     * Show Population Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        VulnerablePopulationDialogViewModel dialogViewModel = new VulnerablePopulationDialogViewModel(
                getContext(),
                (VulnerablePopulationRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = VulnerablePopulationDialogFragment.newInstance();
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
        VulnerablePopulationDialogViewModel dialogViewModel = new VulnerablePopulationDialogViewModel(
                getContext(),
                (VulnerablePopulationRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = VulnerablePopulationDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mVulnerablePopulationAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mVulnerablePopulationAdapter = new VulnerablePopulationFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (VulnerablePopulationViewModel) mViewModel);
        mRowRecycler.setAdapter(mVulnerablePopulationAdapter);
    }
}

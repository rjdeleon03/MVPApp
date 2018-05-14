package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog.DeathCauseDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog.DeathCauseDataDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragmentAdapter;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DeathCauseDataFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeathCauseDataFragment extends BaseAgeGroupFragment {

    private DeathCauseDataFragmentBinding mBinding;
    private DeathCauseDataFragmentAdapter mDeathCauseAdapter;

    public static DeathCauseDataFragment getInstance() {
        return new DeathCauseDataFragment();
    }

    public DeathCauseDataFragment() {
        // Required empty public constructor
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.death_cause_data_fragment, container, false);

        // Initialize binding and set viewModel
        if (mBinding == null) {
            mBinding = DeathCauseDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize spinner
        setupSpinner(root, R.id.nd_death_cause_age_spinner);

        // Initialize row view
        setupRecyclerGrid(root, R.id.nd_death_cause_grid);

        return mBinding.getRoot();
    }

    /**
     * Show Death Cause Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DeathCauseDataDialogViewModel dialogViewModel = new DeathCauseDataDialogViewModel(
                getContext(),
                (DeathCauseRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DeathCauseDataDialogFragment.getInstance();
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
        DeathCauseDataDialogViewModel dialogViewModel = new DeathCauseDataDialogViewModel(
                getContext(),
                (DeathCauseRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DeathCauseDataDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Delete card for selected age group when its delete button is pressed
     */
    @Override
    public void onDeleteCardButtonPressed() {
        refreshData();
    }

    /**
     * Refresh recycler view adapter and dismiss dialog when OK button is pressed
     */
    @Override
    public void onDialogOkButtonPressed() {
        refreshData();
        mDialogFragment.dismiss();
        mDialogFragment = null;
    }

    /**
     * Refreshes the data displayed
     */
    private void refreshData() {
        mSpinnerAdapter.notifyDataSetChanged();
        mAgeGroupSpinner.setSelection(0);
        mDeathCauseAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     * @param controlId
     */
    @Override
    protected void setupRecyclerGrid(View view, int controlId) {
        super.setupRecyclerGrid(view, controlId);
        super.setRecyclerGridLayout(getResources().getConfiguration().orientation);
        mDeathCauseAdapter = new DeathCauseDataFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (DeathCauseDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mDeathCauseAdapter);
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopulationDataFragment extends BaseAgeGroupFragment {

    private PopulationDataFragmentBinding mBinding;
    private PopulationDataFragmentAdapter mPopulationDataAdapter;

    public static PopulationDataFragment newInstance() {
        return new PopulationDataFragment();
    }

    public PopulationDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.population_data_fragment, container, false);

        // Initialize binding and set viewModel
        if (mBinding == null) {
            mBinding = PopulationDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize spinner
        setupSpinner(root, R.id.nd_population_age_spinner);

        // Initialize row view
        setupRecyclerGrid(root, R.id.nd_population_grid);

        return mBinding.getRoot();
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
        mPopulationDataAdapter.notifyDataSetChanged();
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
        mPopulationDataAdapter = new PopulationDataFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (PopulationDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mPopulationDataAdapter);
    }
}

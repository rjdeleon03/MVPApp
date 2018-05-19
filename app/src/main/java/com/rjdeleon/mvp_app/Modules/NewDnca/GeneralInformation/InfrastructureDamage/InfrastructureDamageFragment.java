package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseAgeGroupFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog.InfrastructureDamageDialogViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.InfrastructureDamageFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfrastructureDamageFragment extends BaseAgeGroupFragment {

    private InfrastructureDamageFragmentBinding mBinding;
    private InfrastructureDamageFragmentAdapter mInfrastructureAdapter;

    public static InfrastructureDamageFragment getInstance() {
        return new InfrastructureDamageFragment();
    }

    public InfrastructureDamageFragment() {
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
        View root = inflater.inflate(R.layout.infrastructure_damage_fragment, container, false);

        // Initialize binding and set viewModel
        if (mBinding == null) {
            mBinding = InfrastructureDamageFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize spinner
        setupSpinner(root, R.id.nd_infrastructure_type_spinner);

        // Initialize row view
        setupRecyclerGrid(root, R.id.nd_infrastructure_grid);

        return mBinding.getRoot();
    }

    /**
     * Show infrastructure damage data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        InfrastructureDamageDialogViewModel dialogViewModel = new InfrastructureDamageDialogViewModel(
                getContext(),
                (InfrastructureDamageRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = InfrastructureDamageDialogFragment.getInstance();
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
        InfrastructureDamageDialogViewModel dialogViewModel = new InfrastructureDamageDialogViewModel(
                getContext(),
                (InfrastructureDamageRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = InfrastructureDamageDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");

    }

    /**
     * Delete card for selected infrastructure type when its delete button is pressed
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
        mInfrastructureAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying infrastructure damage data rows
     * @param view
     * @param controlId
     */
    @Override
    protected void setupRecyclerGrid(View view, int controlId) {
        super.setupRecyclerGrid(view, controlId);
        super.setRecyclerGridLayout(getResources().getConfiguration().orientation);
        mInfrastructureAdapter = new InfrastructureDamageFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (InfrastructureDamageViewModel) mViewModel);
        mRowRecycler.setAdapter(mInfrastructureAdapter);
    }
}

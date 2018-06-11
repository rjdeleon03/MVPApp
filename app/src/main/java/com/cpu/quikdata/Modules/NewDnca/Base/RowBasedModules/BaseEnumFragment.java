package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.databinding.BaseRowFragmentBinding;

public abstract class BaseEnumFragment extends BaseSubFragment implements BaseEnumNavigator {

    protected BaseEnumViewModel mViewModel;
    protected Spinner mAgeGroupSpinner;
    protected ArrayAdapter<GenericEnum> mSpinnerAdapter;
    protected RecyclerView mRowRecycler;
    protected BaseEnumDialogFragment mDialogFragment;

    private BaseRowFragmentBinding mBinding;

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.base_row_fragment, container, false);

        // Initialize binding
        if (mBinding == null) {
            mBinding = BaseRowFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize spinner
        setupSpinner(root);

        // Initiailize row view
        setupRecyclerGrid(root);

        return mBinding.getRoot();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(BaseEnumViewModel viewModel) {
        mViewModel = viewModel;
        mViewModel.setBaseAgeGroupNavigator(this);
    }

    /**
     * Sets up AgeGroup spinner
     * @param view
     */
    protected void setupSpinner(View view) {
        mAgeGroupSpinner = view.findViewById(R.id.nd_row_controls_spinner);
        Activity activity = getActivity();
        mSpinnerAdapter = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_spinner_dropdown_item,
                mViewModel.ageGroupList
        );
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeGroupSpinner.setAdapter(mSpinnerAdapter);
    }

    /**
     * Sets up RecyclerView grid for displaying age group rows
     * @param view
     */
    protected void setupRecyclerGrid(View view) {
        mRowRecycler = view.findViewById(R.id.nd_row_layout_grid);
        mRowRecycler.setHasFixedSize(true);
        mRowRecycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        setRecyclerGridLayout(getResources().getConfiguration().orientation);
    }

    /**
     * Sets column count of RecyclerView depending on device orientation
     * @param orientation
     */
    protected void setRecyclerGridLayout(int orientation) {

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((StaggeredGridLayoutManager) mRowRecycler.getLayoutManager()).setSpanCount(2);
            return;
        }
        ((StaggeredGridLayoutManager) mRowRecycler.getLayoutManager()).setSpanCount(1);
    }

    /**
     * Checks if a dialog is already shown
     * @return
     */
    protected boolean dialogIsAlreadyShown() {
        return mDialogFragment != null;
    }

    /**
     * Handle configuration changes
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRecyclerGridLayout(newConfig.orientation);
    }

    /**
     * Dismiss dialog when close button is pressed
     */
    @Override
    public void onDialogCloseButtonPressed() {
        mDialogFragment.dismiss();
        mDialogFragment = null;
    }

    /**
     * Delete card for selected row when its delete button is pressed
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
    protected void refreshData() {
        mSpinnerAdapter.notifyDataSetChanged();
        mAgeGroupSpinner.setSelection(0);
    }

}

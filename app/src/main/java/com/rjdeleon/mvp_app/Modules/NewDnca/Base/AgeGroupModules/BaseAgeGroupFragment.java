package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogFragment;

public abstract class BaseAgeGroupFragment extends Fragment implements BaseAgeGroupNavigator {

    protected BaseAgeGroupViewModel mViewModel;
    protected Spinner mAgeGroupSpinner;
    protected ArrayAdapter<GenericEnum> mSpinnerAdapter;
    protected RecyclerView mRowRecycler;
    protected BaseAgeGroupDialogFragment mDialogFragment;

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(BaseAgeGroupViewModel viewModel) {
        mViewModel = viewModel;
        mViewModel.setBaseAgeGroupNavigator(this);
    }

    /**
     * Sets up AgeGroup spinner
     * @param view
     * @param controlId
     */
    protected void setupSpinner(View view, int controlId) {
        mAgeGroupSpinner = view.findViewById(controlId);
        mSpinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                mViewModel.ageGroupList
        );
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeGroupSpinner.setAdapter(mSpinnerAdapter);
    }

    /**
     * Sets up RecyclerView grid for displaying age group rows
     * @param view
     * @param controlId
     */
    protected void setupRecyclerGrid(View view, int controlId) {
        mRowRecycler = view.findViewById(controlId);
        mRowRecycler.setHasFixedSize(true);
        mRowRecycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

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

}

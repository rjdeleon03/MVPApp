package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog.CasualtiesDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog.CasualtiesDataDialogViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.CasualtiesDataFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CasualtiesDataFragment extends BaseAgeGroupFragment {

    private CasualtiesDataFragmentBinding mBinding;
    private CasualtiesDataFragmentAdapter mCasualtiesDataAdapter;

    public static CasualtiesDataFragment getInstance() {
        return new CasualtiesDataFragment();
    }

    public CasualtiesDataFragment() {
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
        View root = inflater.inflate(R.layout.casualties_data_fragment, container, false);

        // Initialize binding and set viewModel
        if (mBinding == null) {
            mBinding = CasualtiesDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize spinner
        setupSpinner(root, R.id.nd_casualties_age_spinner);

        // Initialize row view
        setupRecyclerGrid(root, R.id.nd_casualties_grid);

        return mBinding.getRoot();
    }

    /**
     * Show Casualties Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        CasualtiesDataDialogViewModel dialogViewModel = new CasualtiesDataDialogViewModel(
                getContext(),
                (CasualtiesDataRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = CasualtiesDataDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {

    }

    /**
     * Delete card for selected age group when its delete button is pressed
     */
    @Override
    public void onDeleteCardButtonPressed() {

    }

    @Override
    public void onDialogOkButtonPressed() {

    }

    /**
     * Refreshes the data displayed
     */
    private void refreshData() {
        mSpinnerAdapter.notifyDataSetChanged();
        mAgeGroupSpinner.setSelection(0);
        mCasualtiesDataAdapter.notifyDataSetChanged();
    }
}

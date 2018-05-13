package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.BaseAgeGroupFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.VulnerablePopulationFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class VulnerablePopulationFragment extends BaseAgeGroupFragment implements BaseAgeGroupNavigator {

    private VulnerablePopulationFragmentBinding mBinding;

    public static VulnerablePopulationFragment getInstance() {
        return new VulnerablePopulationFragment();
    }

    public VulnerablePopulationFragment() {
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
        View root = inflater.inflate(R.layout.vulnerable_population_fragment, container, false);

        // Initialize binding and set viewModel
        if (mBinding == null) {
            mBinding = VulnerablePopulationFragmentBinding.bind(root);
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
//        PopulationDataDialogViewModel dialogViewModel = new PopulationDataDialogViewModel(
//                getContext(),
//                mViewModel,
//                mAgeGroupSpinner.getSelectedItemPosition(),
//                true);
//        dialogViewModel.setPopulationDataNavigator(this);
//        mDialogFragment = PopulationDataDialogFragment.newInstance();
//        mDialogFragment.setViewModel(dialogViewModel);
//        mDialogFragment.show(getChildFragmentManager(), "");
//
//        VulnerablePopulationViewModel vulnerablePopulationViewModel = new VulnerablePopulationViewModel(
//                getContext(),
//                mViewModel,
//
//        )
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

    /**
     * Refresh recycler view adapter and dismiss dialog when OK button is pressed
     */
    @Override
    public void onDialogOkButtonPressed() {
    }

    /**
     * Dismiss dialog when close button is pressed
     */
    @Override
    public void onDialogCloseButtonPressed() {
    }
}

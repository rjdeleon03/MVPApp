package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopulationDataFragment extends Fragment implements PopulationDataNavigator  {

    private PopulationDataViewModel mViewModel;
    private PopulationDataFragmentBinding mBinding;

    private Spinner mAgeGroupSpinner;
    private ArrayAdapter<PopulationData.AgeGroup> mSpinnerAdapter;

    public static PopulationDataFragment newInstance() {
        return new PopulationDataFragment();
    }

    public PopulationDataFragment() {
        // Required empty public constructor
    }

    public void setViewModel(PopulationDataViewModel viewModel) {
        mViewModel = viewModel;
        mViewModel.setPopulationDataNavigator(this);
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
        setupSpinner(root);

        return mBinding.getRoot();
    }

    /**
     * Show Population Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        PopulationDataDialogViewModel dialogViewModel = new PopulationDataDialogViewModel(getContext());
        PopulationDataDialogFragment dialogFragment = PopulationDataDialogFragment.newInstance();
        dialogFragment.setViewModel(dialogViewModel);
        dialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Delete card for selected age group when its delete button is pressed
     */
    @Override
    public void onDeleteCardButtonPressed() {

    }

    /**
     * Initialize AgeGroup spinner
     */
    private void setupSpinner(View view) {
        mAgeGroupSpinner = view.findViewById(R.id.nd_population_age_spinner);
        mSpinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                mViewModel.getAgeGroupList()
        );
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeGroupSpinner.setAdapter(mSpinnerAdapter);
    }
}

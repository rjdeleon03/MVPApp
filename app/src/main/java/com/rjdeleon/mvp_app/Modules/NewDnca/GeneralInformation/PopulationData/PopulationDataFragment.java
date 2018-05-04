package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopulationDataFragment extends Fragment {

    private PopulationDataViewModel mViewModel;

    public static PopulationDataFragment newInstance() {
        return new PopulationDataFragment();
    }

    public PopulationDataFragment() {
        // Required empty public constructor
    }

    public void setViewModel(PopulationDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.population_data_fragment, container, false);
    }

}

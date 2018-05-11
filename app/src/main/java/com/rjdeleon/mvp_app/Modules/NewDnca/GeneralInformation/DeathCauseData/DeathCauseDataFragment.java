package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeathCauseDataFragment extends Fragment {

    private DeathCauseDataViewModel mViewModel;

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
        return inflater.inflate(R.layout.death_cause_data_fragment, container, false);
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(DeathCauseDataViewModel viewModel) {
        mViewModel = viewModel;
    }
}

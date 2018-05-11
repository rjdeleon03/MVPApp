package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CasualtiesDataFragment extends Fragment {

    private CasualtiesDataViewModel mViewModel;

    public static CasualtiesDataFragment getInstance() {
        return new CasualtiesDataFragment();
    }

    public CasualtiesDataFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(CasualtiesDataViewModel viewModel) {
        mViewModel = viewModel;
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
        return inflater.inflate(R.layout.casualties_data_fragment, container, false);
    }

}

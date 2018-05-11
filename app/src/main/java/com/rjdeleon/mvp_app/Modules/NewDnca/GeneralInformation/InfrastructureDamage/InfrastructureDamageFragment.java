package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfrastructureDamageFragment extends Fragment {

    private InfrastructureDamageViewModel mViewModel;

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
        return inflater.inflate(R.layout.infrastructure_damage_fragment, container, false);
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(InfrastructureDamageViewModel viewModel) {
        mViewModel = viewModel;
    }

}

package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.VulnerablePopulation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;

public class VulnerablePopulationFragment extends BaseFragment {


    public VulnerablePopulationFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Vulnerable Population";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vulnerable_population_fragment, container, false);
    }

}
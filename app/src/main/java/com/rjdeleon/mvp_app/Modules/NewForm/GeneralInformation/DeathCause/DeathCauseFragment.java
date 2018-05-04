package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.DeathCause;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;

public class DeathCauseFragment extends BaseFragment {


    public DeathCauseFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Cause of Death";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.death_cause_fragment, container, false);
    }

}

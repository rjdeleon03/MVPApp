package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.InfraDamage;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;

public class InfraDamageFragment extends BaseFragment {


    public InfraDamageFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Damage to Infrastructures";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.infra_damage_fragment, container, false);
    }

}

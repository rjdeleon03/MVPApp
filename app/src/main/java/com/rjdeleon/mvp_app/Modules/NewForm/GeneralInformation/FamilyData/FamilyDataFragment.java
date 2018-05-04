package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.FamilyData;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;

public class FamilyDataFragment extends BaseFragment {


    public FamilyDataFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Family and Household Data";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.family_data_fragment, container, false);
    }

}

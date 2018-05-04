package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.Casualties;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;

public class CasualtiesFragment extends BaseFragment {


    public CasualtiesFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Casualties";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.casualties_fragment, container, false);
    }
}

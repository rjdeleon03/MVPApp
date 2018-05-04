package com.rjdeleon.mvp_app.Modules.NewFormV2.FormDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

public class NewDncaDetailsFragment extends Fragment implements NewDncaDetailsContract.View {


    public NewDncaDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_dnca_details_fragment, container, false);
    }

    @Override
    public void setPresenter(NewDncaDetailsContract.Presenter presenter) {

    }
}

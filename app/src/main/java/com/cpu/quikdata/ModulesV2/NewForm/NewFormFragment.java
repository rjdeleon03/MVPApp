package com.cpu.quikdata.ModulesV2.NewForm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFormFragment extends Fragment {


    public NewFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_form_fragment, container, false);
    }

}

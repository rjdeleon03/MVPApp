package com.cpu.quikdata.ModulesV2.NewForm.Base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateMultiPageFragment extends Fragment {


    public TemplateMultiPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.template_multi_page_fragment, container, false);
    }

}

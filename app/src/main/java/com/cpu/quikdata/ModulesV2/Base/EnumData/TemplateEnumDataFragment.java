package com.cpu.quikdata.ModulesV2.Base.EnumData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TemplateEnumDataFragment<VM extends TemplateEnumDataViewModel> extends BaseFragment<VM> {

    public TemplateEnumDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.template_enum_data_fragment, container, false);
    }

}

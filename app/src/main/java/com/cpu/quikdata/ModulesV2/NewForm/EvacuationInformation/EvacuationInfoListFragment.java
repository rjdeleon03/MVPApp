package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataFragment;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationInfoListFragment extends TemplateListDataFragment<EvacuationInfoListViewModel> {


    public EvacuationInfoListFragment() {
        // Required empty public constructor
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationInfoListFragment newInstance() {
        return new EvacuationInfoListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.evacuation_info_list_fragment, container, false);
    }

}

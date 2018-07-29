package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation;

import android.support.v4.app.Fragment;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationInfoListFragment extends TemplateListDataFragment<EvacuationInfoListViewModel> {


    public EvacuationInfoListFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationInfoListFragment newInstance() {
        return new EvacuationInfoListFragment();
    }

}

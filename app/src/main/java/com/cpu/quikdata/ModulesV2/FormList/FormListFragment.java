package com.cpu.quikdata.ModulesV2.FormList;


import android.support.v4.app.Fragment;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormListFragment extends TemplateListDataFragment<FormListViewModel> {

    public FormListFragment() {
        // Required empty public constructor
//        mTag = "DRAFT_FORMS_LIST";
    }

    /**
     * Gets new instance
     * @return
     */
    public static FormListFragment newInstance() {
        return new FormListFragment();
    }

    /**
     * Handles onResume event
     */
    @Override
    public void onResume() {
        super.onResume();
        mViewModel.onViewResumed();
    }
}

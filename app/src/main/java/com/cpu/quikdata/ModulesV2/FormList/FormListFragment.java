package com.cpu.quikdata.ModulesV2.FormList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FormListFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormListFragment extends TemplateListDataFragment<FormListViewModel> {

    public FormListFragment() {
        // Required empty public constructor
    }

    /**
     * Gets new instance
     * @return
     */
    public static FormListFragment newInstance() {
        return new FormListFragment();
    }
}

package com.cpu.quikdata.ModulesV2.Base.ListData;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FormListFragmentBinding;

public class TemplateListDataFragment<VM extends TemplateListDataViewModel> extends BaseFragment<VM> {

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.form_list_fragment, container, false);
        FormListFragmentBinding binding = FormListFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);

        // Setup recyclerView
        RecyclerView rv = view.findViewById(R.id.form_list_view);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}

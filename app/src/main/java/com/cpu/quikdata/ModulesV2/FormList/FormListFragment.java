package com.cpu.quikdata.ModulesV2.FormList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FormListFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormListFragment extends Fragment {

    private FormListViewModel mViewModel;


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

    /**
     * Sets the viewModel
     * @param formListViewModel
     */
    public void setViewModel(FormListViewModel formListViewModel) {
        mViewModel = formListViewModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.form_list_fragment, container, false);
        FormListFragmentBinding binding = FormListFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);
        return view;
    }

}

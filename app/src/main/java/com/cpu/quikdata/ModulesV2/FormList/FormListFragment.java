package com.cpu.quikdata.ModulesV2.FormList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModelsV2.Form.DncaForm;
import com.cpu.quikdata.ModulesV2.Base.ListData.ListDataFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FormListFragmentBinding;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormListFragment extends ListDataFragment<FormListViewModel> {

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

package com.cpu.quikdata.Modules.NewDnca.Evacuation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.EvacuationListFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvacuationListFragment extends BaseMultiPageFragment {

    private EvacuationListViewModel mViewModel;
    private RecyclerView mRecyclerView;

    public static EvacuationListFragment newInstance() {
        return new EvacuationListFragment();
    }

    public EvacuationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.evacuation_list_fragment, container, false);
        EvacuationListFragmentBinding binding = EvacuationListFragmentBinding.bind(root);
        binding.setViewModel(mViewModel);

        setupListAdapter(root);

        return binding.getRoot();
    }


    /**
     * Set the viewModel
     * @param evacuationListViewModel
     */
    public void setViewModel(EvacuationListViewModel evacuationListViewModel) {
        mViewModel = evacuationListViewModel;
    }



    /**
     * Sets up the adapter for the DNCA forms list
     */
    private void setupListAdapter(View view) {

        // Initialize adapter
        EvacuationListAdapter adapter = new EvacuationListAdapter(mViewModel);


        // Initialize RecyclerView
        mRecyclerView = view.findViewById(R.id.dnca_list_view);
        mRecyclerView.setHasFixedSize(true);

        // Set RecyclerView layout and adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        mRecyclerView.setAdapter(adapter);
    }

}

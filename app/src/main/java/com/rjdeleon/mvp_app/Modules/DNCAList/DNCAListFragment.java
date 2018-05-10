package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DncaListFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DNCAListFragment extends Fragment {

    private DNCAListViewModel mDncaListViewModel;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    /**
     * Constructor
     */
    public DNCAListFragment() {
        // Required empty public constructor
    }

    /**
     * Static method to create new DNCAListViewModel instance
     * @return
     */
    public static DNCAListFragment newInstance() {
        return new DNCAListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.dnca_list_fragment, container, false);

        // Bind viewModel
        DncaListFragmentBinding binding = DncaListFragmentBinding.bind(root);
        binding.setViewModel(mDncaListViewModel);

        // Initialize RecyclerView
        mRecyclerView = root.findViewById(R.id.dnca_list_view);
        mRecyclerView.setHasFixedSize(true);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupListAdapter();
        mDncaListViewModel.start();
    }

    /**
     * Sets up the adapter for the DNCA forms list
     */
    private void setupListAdapter() {

        // Initialize adapter
        mAdapter = new DNCAListAdapter(mDncaListViewModel);

        // Set RecyclerView layout and adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        mRecyclerView.setAdapter(mAdapter);
    }


    /**
     * Set the viewModel
     * @param dncaListViewModel
     */
    public void setViewModel(DNCAListViewModel dncaListViewModel) {
        mDncaListViewModel = dncaListViewModel;
    }
}

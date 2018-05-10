package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DNCAListFragment extends Fragment {

    private DNCAListViewModel mDncaListViewModel;

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
        return inflater.inflate(R.layout.dnca_list_fragment, container, false);
    }

    /**
     * Set the viewModel
     * @param dncaListViewModel
     */
    public void setViewModel(DNCAListViewModel dncaListViewModel) {
        mDncaListViewModel = dncaListViewModel;
    }
}

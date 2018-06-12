package com.cpu.quikdata.Modules.NewDnca.CaseStories;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.CaseStoriesFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaseStoriesFragment extends Fragment {

    private CaseStoriesViewModel mViewModel;
    private CaseStoriesFragmentBinding mBinding;
    private CaseStoriesFragmentAdapter mCaseStoriesAdapter;
    private RecyclerView mImageRecycler;

    public static CaseStoriesFragment newInstance() {
        return new CaseStoriesFragment();
    }

    public CaseStoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull CaseStoriesViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the view and binds the viewModel
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.case_stories_fragment, container, false);
        if (mBinding == null) {
            mBinding = CaseStoriesFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        setupImageRecycler(root);

        return root;
    }

    /**
     * Sets up recycler view for images
     * @param view
     */
    private void setupImageRecycler(View view) {
        mImageRecycler = view.findViewById(R.id.nd_case_image_list);
        mImageRecycler.setHasFixedSize(true);
        mImageRecycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mCaseStoriesAdapter = new CaseStoriesFragmentAdapter(
                getContext().getApplicationContext(),
                mViewModel);
        mImageRecycler.setAdapter(mCaseStoriesAdapter);
    }

    /**
     * Refreshes the images displayed in the recycler view
     */
    public void refreshData() {
        if (mCaseStoriesAdapter != null) {
            int w = mImageRecycler.getWidth();
            int h = mImageRecycler.getHeight();
            mCaseStoriesAdapter.notifyDataSetChanged();
        }
    }
}

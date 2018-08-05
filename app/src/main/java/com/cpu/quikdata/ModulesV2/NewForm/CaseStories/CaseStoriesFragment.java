package com.cpu.quikdata.ModulesV2.NewForm.CaseStories;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateCaseStoriesFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaseStoriesFragment extends BaseFragment<CaseStoriesViewModel> implements ICaseStoriesFragment {


    public CaseStoriesFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.CASE_STORIES.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static CaseStoriesFragment newInstance() {

        return new CaseStoriesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.template_case_stories_fragment, container, false);
        TemplateCaseStoriesFragmentBinding binding = TemplateCaseStoriesFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);

        // Setup recycler view
        RecyclerView recyclerView = view.findViewById(R.id.template_case_stories_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        return binding.getRoot();
    }

    /**
     * Handles item delete button pressed event
     * @param index
     */
    @Override
    public void onItemDeleteButtonPressed(int index) {
        // TODO: Call viewModel to handle deletion
        mViewModel.deleteImagePathAtIndex(index);
    }

    /**
     * Handle fragment paused event
     */
    @Override
    public void onPause() {
        mViewModel.onViewPaused();
        super.onPause();
    }
}

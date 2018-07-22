package com.cpu.quikdata.ModulesV2.Base.MainTemplate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.databinding.TemplateQuestionFragmentBinding;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TemplateQuestionFragment extends BaseFragment<TemplateQuestionViewModel> {

    public TemplateQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.template_question_fragment, container, false);
        TemplateQuestionFragmentBinding binding = TemplateQuestionFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Inform viewModel that view has been paused and
        // models need to be updated
        mViewModel.onViewPaused();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}

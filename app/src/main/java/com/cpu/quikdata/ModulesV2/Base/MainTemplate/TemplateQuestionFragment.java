package com.cpu.quikdata.ModulesV2.Base.MainTemplate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewModel.TemplateQuestionViewModel;
import com.cpu.quikdata.databinding.TemplateQuestionFragmentBinding;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateQuestionFragment extends Fragment {

    private TemplateQuestionViewModel mViewModel;

    public TemplateQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Gets new instance
     * @return
     */
    public static TemplateQuestionFragment newInstance() {
        return new TemplateQuestionFragment();
    }

    /**
     * Sets the viewModel
     * @param templateQuestionViewModel
     */
    public void setViewModel(TemplateQuestionViewModel templateQuestionViewModel) {
        mViewModel = templateQuestionViewModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.template_question_fragment, container, false);
        TemplateQuestionFragmentBinding binding = TemplateQuestionFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);

        RecyclerView recyclerView = view.findViewById(R.id.template_question_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}

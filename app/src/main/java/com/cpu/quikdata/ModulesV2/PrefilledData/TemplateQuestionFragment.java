package com.cpu.quikdata.ModulesV2.PrefilledData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return inflater.inflate(R.layout.template_question_fragment, container, false);
    }

}

package com.cpu.quikdata.ModulesV2.NewForm.Base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormViewModel;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateMultiPageFragment extends Fragment {

    private FormDetailsViewModel mViewModel;

    public TemplateMultiPageFragment() {
        // Required empty public constructor
    }

    /**
     * Gets new instance
     * @return
     */
    public static TemplateMultiPageFragment newInstance() {
        return new TemplateMultiPageFragment();
    }

    /**
     * Sets the viewModel
     * @param newFormViewModel
     */
    public void setViewModel(FormDetailsViewModel newFormViewModel) {
        mViewModel = newFormViewModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.template_multi_page_fragment, container, false);
    }

}

package com.cpu.quikdata.ModulesV2.NewForm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.databinding.NewFormFragmentBinding;
import com.cpu.quikdata.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFormFragment extends BaseFragment {

    private NewFormViewModel mViewModel;

    public NewFormFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.MENU.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static NewFormFragment newInstance() {
        return new NewFormFragment();
    }

    /**
     * Sets the viewModel
     * @param newFormViewModel
     */
    public void setViewModel(NewFormViewModel newFormViewModel) {
        mViewModel = newFormViewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.new_form_fragment, container, false);
        NewFormFragmentBinding binding = NewFormFragmentBinding.bind(view);
        binding.setViewModel(mViewModel);
        return view;
    }

}

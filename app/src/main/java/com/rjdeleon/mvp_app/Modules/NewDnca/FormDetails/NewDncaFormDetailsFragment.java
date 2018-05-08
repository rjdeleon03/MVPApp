package com.rjdeleon.mvp_app.Modules.NewDnca.FormDetails;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaFormDetailsFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaFormDetailsFragment extends Fragment {

    private NewDncaFormDetailsViewModel mViewModel;
    private NewDncaFormDetailsFragmentBinding mBinding;

    public static NewDncaFormDetailsFragment newInstance() {
        return new NewDncaFormDetailsFragment();
    }

    public NewDncaFormDetailsFragment() {
        // Required empty public constructor
    }

    public void setViewModel(@NonNull NewDncaFormDetailsViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.new_dnca_form_details_fragment, container, false);
        if (mBinding == null) {
            mBinding = NewDncaFormDetailsFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);
        return root;
    }

}

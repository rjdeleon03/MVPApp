package com.rjdeleon.mvp_app.Modules.NewDnca;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaFragment extends Fragment {

    private NewDncaViewModel mViewModel;

    private NewDncaFragmentBinding mBinding;

    public static NewDncaFragment newInstance() {
        return new NewDncaFragment();
    }

    public NewDncaFragment() {
        // Required empty public constructor
    }

    public void setViewModel(@NonNull NewDncaViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.new_dnca_fragment, container, false);
        if (mBinding == null) {
            mBinding = NewDncaFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return mBinding.getRoot();
    }

}

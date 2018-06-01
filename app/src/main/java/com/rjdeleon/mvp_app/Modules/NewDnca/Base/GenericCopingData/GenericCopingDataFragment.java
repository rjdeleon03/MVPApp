package com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.databinding.BaseCopingDataFragmentBinding;
import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenericCopingDataFragment extends Fragment {

    private BaseCopingDataFragmentBinding mBinding;
    private GenericCopingDataViewModel mViewModel;

    public GenericCopingDataFragment() {
        // Required empty public constructor
    }

    public static GenericCopingDataFragment newInstance() {
        return new GenericCopingDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull GenericCopingDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.base_coping_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = BaseCopingDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }
}

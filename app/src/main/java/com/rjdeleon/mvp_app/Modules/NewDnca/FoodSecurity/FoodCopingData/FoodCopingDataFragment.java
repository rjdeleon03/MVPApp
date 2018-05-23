package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodCopingData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.databinding.FoodCopingDataFragmentBinding;
import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodCopingDataFragment extends Fragment {

    private FoodCopingDataFragmentBinding mBinding;
    private FoodCopingDataViewModel mViewModel;

    public FoodCopingDataFragment() {
        // Required empty public constructor
    }

    public static FoodCopingDataFragment newInstance() {
        return new FoodCopingDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull FoodCopingDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.food_coping_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = FoodCopingDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

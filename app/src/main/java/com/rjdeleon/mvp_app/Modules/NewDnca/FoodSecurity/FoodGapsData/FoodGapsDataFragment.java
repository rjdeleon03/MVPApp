package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodGapsData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.FoodGapsDataFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodGapsDataFragment extends Fragment {

    private FoodGapsDataFragmentBinding mBinding;
    private FoodGapsDataViewModel mViewModel;


    public FoodGapsDataFragment() {
        // Required empty public constructor
    }

    public static FoodGapsDataFragment newInstance() {
        return new FoodGapsDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(FoodGapsDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.food_gaps_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = FoodGapsDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.databinding.FoodImpactDataFragmentBinding;
import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodImpactDataFragment extends Fragment {

    private FoodImpactDataFragmentBinding mBinding;
    private FoodImpactDataViewModel mViewModel;

    public FoodImpactDataFragment() {
        // Required empty public constructor
    }

    public static FoodImpactDataFragment newInstance() {
        return new FoodImpactDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull FoodImpactDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.food_impact_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = FoodImpactDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

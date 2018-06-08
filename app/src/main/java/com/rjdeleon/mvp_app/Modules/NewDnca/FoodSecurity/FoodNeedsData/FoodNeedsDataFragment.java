package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodNeedsData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.FoodNeedsDataFragmentBinding;

import static com.rjdeleon.mvp_app.AppConstants.FoodSecurityComponent.FOOD_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodNeedsDataFragment extends BaseSubFragment {

    private FoodNeedsDataFragmentBinding mBinding;
    private FoodNeedsDataViewModel mViewModel;

    public FoodNeedsDataFragment() {
        setFragmentTag(FOOD_NEEDS.toString());
    }

    public static FoodNeedsDataFragment newInstance() {
        return new FoodNeedsDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull FoodNeedsDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.food_needs_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = FoodNeedsDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.LivelihoodsNeedsDataFragmentBinding;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsNeedsDataFragment extends BaseSubFragment {

    private LivelihoodsNeedsDataViewModel mViewModel;
    private LivelihoodsNeedsDataFragmentBinding mBinding;

    public LivelihoodsNeedsDataFragment() {
        setFragmentTag(LIVELIHOODS_NEEDS.toString());
    }

    public static LivelihoodsNeedsDataFragment newInstance() {
        return new LivelihoodsNeedsDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull LivelihoodsNeedsDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.livelihoods_needs_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = LivelihoodsNeedsDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }
}

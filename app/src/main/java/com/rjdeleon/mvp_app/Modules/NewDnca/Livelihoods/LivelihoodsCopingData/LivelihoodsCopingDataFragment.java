package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsCopingData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.LivelihoodsCopingDataFragmentBinding;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_COPING;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsCopingDataFragment extends BaseSubFragment {

    private LivelihoodsCopingDataViewModel mViewModel;
    private LivelihoodsCopingDataFragmentBinding mBinding;

    public LivelihoodsCopingDataFragment() {
        setFragmentTag(LIVELIHOODS_COPING.toString());
    }

    public static LivelihoodsCopingDataFragment newInstance() {
        return new LivelihoodsCopingDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull LivelihoodsCopingDataViewModel viewModel) {
        mViewModel = viewModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.livelihoods_coping_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = LivelihoodsCopingDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

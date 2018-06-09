package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsGapsData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.databinding.LivelihoodsGapsDataFragmentBinding;
import com.rjdeleon.mvp_app.R;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_GAPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivelihoodsGapsDataFragment extends BaseSubFragment {

    private LivelihoodsGapsDataFragmentBinding mBinding;
    private LivelihoodsGapsDataViewModel mViewModel;

    public LivelihoodsGapsDataFragment() {
        setFragmentTag(LIVELIHOODS_GAPS.toString());
    }

    public static LivelihoodsGapsDataFragment newInstance() {
        return new LivelihoodsGapsDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull LivelihoodsGapsDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.livelihoods_gaps_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = LivelihoodsGapsDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

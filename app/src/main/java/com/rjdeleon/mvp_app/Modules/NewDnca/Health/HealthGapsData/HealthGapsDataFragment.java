package com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthGapsData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.HealthGapsDataFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthGapsDataFragment extends Fragment {

    private HealthGapsDataFragmentBinding mBinding;
    private HealthGapsDataViewModel mViewModel;

    public HealthGapsDataFragment() {
        // Required empty public constructor
    }

    public static HealthGapsDataFragment newInstance() {
        return new HealthGapsDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(HealthGapsDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.health_gaps_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = HealthGapsDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterGapsData;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.databinding.ShelterGapsDataFragmentBinding;
import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterGapsDataFragment extends Fragment {

    private ShelterGapsDataViewModel mViewModel;
    private ShelterGapsDataFragmentBinding mBinding;

    public ShelterGapsDataFragment() {
        // Required empty public constructor
    }

    public static ShelterGapsDataFragment newInstance() {
        return new ShelterGapsDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull ShelterGapsDataViewModel viewModel) {
        mViewModel = viewModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.shelter_gaps_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = ShelterGapsDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

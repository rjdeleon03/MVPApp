package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterCopingData;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.ShelterCopingDataFragmentBinding;

import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_COPING;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterCopingDataFragment extends BaseSubFragment {

    private ShelterCopingDataViewModel mViewModel;
    private ShelterCopingDataFragmentBinding mBinding;

    public ShelterCopingDataFragment() {
        setFragmentTag(SHELTER_COPING.toString());
    }

    public static ShelterCopingDataFragment newInstance() {
        return new ShelterCopingDataFragment();
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull ShelterCopingDataViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.shelter_coping_data_fragment, container, false);
        if (mBinding == null) {
            mBinding = ShelterCopingDataFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }
}

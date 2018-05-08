package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.databinding.CalamityDetailsFragmentBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalamityDetailsFragment extends Fragment {

    private CalamityDetailsViewModel mViewModel;
    private CalamityDetailsFragmentBinding mBinding;

    public static CalamityDetailsFragment newInstance() {
        return new CalamityDetailsFragment();
    }

    public CalamityDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull CalamityDetailsViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the view and binds the viewModel
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(com.rjdeleon.mvp_app.R.layout.calamity_details_fragment, container, false);
        if (mBinding == null) {
            mBinding = CalamityDetailsFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        return root;
    }

}

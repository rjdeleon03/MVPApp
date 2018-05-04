package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaGenInfoFragment extends Fragment {

    private NewDncaGenInfoViewModel mViewModel;

    public static NewDncaGenInfoFragment newInstance() {
        return new NewDncaGenInfoFragment();
    }

    public NewDncaGenInfoFragment() {
        // Required empty public constructor
    }

    public void setViewModel(@NonNull NewDncaGenInfoViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_dnca_gen_info_fragment, container, false);
    }

}

package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalamityDetailsFragment extends Fragment {

    private CalamityDetailsViewModel mViewModel;

    public static CalamityDetailsFragment newInstance() {
        return new CalamityDetailsFragment();
    }

    public CalamityDetailsFragment() {
        // Required empty public constructor
    }

    public void setViewModel(@NonNull CalamityDetailsViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(com.rjdeleon.mvp_app.R.layout.calamity_details_fragment, container, false);
    }

}

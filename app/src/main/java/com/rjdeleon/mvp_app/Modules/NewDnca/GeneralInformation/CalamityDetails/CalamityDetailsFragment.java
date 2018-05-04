package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalamityDetailsFragment extends Fragment {


    public CalamityDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(com.rjdeleon.mvp_app.R.layout.calamity_details_fragment, container, false);
    }

}

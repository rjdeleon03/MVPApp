package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.CalamityDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Base.BaseFragment;

public class CalamityDetailsFragment extends BaseFragment implements CalamityDetailsContract.View {

    private CalamityDetailsPresenter mPresenter;

    public CalamityDetailsFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Calamity Details";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mPresenter = new CalamityDetailsPresenter(this);

        return inflater.inflate(R.layout.calamity_details_fragment_v1, container, false);
    }
}

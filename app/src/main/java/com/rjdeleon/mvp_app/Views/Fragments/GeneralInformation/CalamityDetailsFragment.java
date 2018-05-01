package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.CalamityDetailsContract;
import com.rjdeleon.mvp_app.Presenters.GeneralInformation.CalamityDetailsPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

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

        return inflater.inflate(R.layout.calamity_details_fragment, container, false);
    }
}

package com.rjdeleon.mvp_app.Views.Fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormGenInfoContract;
import com.rjdeleon.mvp_app.Presenters.NewFormGenInfoPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewFormGenInfoFragmentBinding;

public class NewFormGenInfoFragment extends BaseFragment implements NewFormGenInfoContract.View {

    private NewFormGenInfoPresenter mPresenter;

    public NewFormGenInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPresenter = new NewFormGenInfoPresenter(this, (NewFormContract.Presenter)navigationPresenter);
        NewFormGenInfoFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.new_form_gen_info_fragment, container, false);
        binding.setPresenter(mPresenter);
        View view = binding.getRoot();

        Context context = getContext();
        TabLayout tabLayout = view.findViewById(R.id.nf_gen_info_tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_calamity", "drawable", context.getPackageName())));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_population", "drawable", context.getPackageName())));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_injuries", "drawable", context.getPackageName())));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_building", "drawable", context.getPackageName())));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Inflate the layout for this fragment
        return view;
    }
}

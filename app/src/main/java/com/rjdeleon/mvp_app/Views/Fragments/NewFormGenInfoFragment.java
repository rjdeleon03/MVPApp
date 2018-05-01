package com.rjdeleon.mvp_app.Views.Fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormGenInfoContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Presenters.NewFormGenInfoPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.CalamityDetailsFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.CasualtiesFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.DeathCauseFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.FamilyDataFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.GenInfoFragmentAdapter;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.InfraDamageFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.VulnerablePopulationFragment;
import com.rjdeleon.mvp_app.databinding.NewFormGenInfoFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class NewFormGenInfoFragment extends BaseFragment implements NewFormGenInfoContract.View {

    private NewFormGenInfoPresenter mPresenter;
    private GenInfoFragmentAdapter mAdapter;
    private ViewPager mPager;

    private List<Fragment> mFragmentList;

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

        // Create fragment list for pager
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new CalamityDetailsFragment());
        mFragmentList.add(new PopulationDataFragment());
        mFragmentList.add(new FamilyDataFragment());
        mFragmentList.add(new VulnerablePopulationFragment());
        mFragmentList.add(new CasualtiesFragment());
        mFragmentList.add(new DeathCauseFragment());
        mFragmentList.add(new InfraDamageFragment());

        mAdapter = new GenInfoFragmentAdapter(getActivity().getSupportFragmentManager(), mFragmentList);
        mPager = view.findViewById(R.id.nf_gen_info_pager);
        mPager.setAdapter(mAdapter);

//        Context context = getContext();
//        TabLayout tabLayout = view.findViewById(R.id.nf_gen_info_tabs);
//        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_calamity", "drawable", context.getPackageName())));
//        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_population", "drawable", context.getPackageName())));
//        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_injuries", "drawable", context.getPackageName())));
//        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getIdentifier("ic_building", "drawable", context.getPackageName())));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Inflate the layout for this fragment
        return view;
    }
}

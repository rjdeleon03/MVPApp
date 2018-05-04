package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.rjdeleon.mvp_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaGenInfoFragment extends Fragment {

    private NewDncaGenInfoViewModel mViewModel;
    private NewDncaGenInfoFragmentAdapter mAdapter;
    private ViewPager mPager;

    private CalamityDetailsViewModel mCalamityDetailsViewModel;
    private PopulationDataViewModel mPopulationDataViewModel;

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
        View root = inflater.inflate(R.layout.new_dnca_gen_info_fragment, container, false);

        mAdapter = new NewDncaGenInfoFragmentAdapter(getChildFragmentManager());

        // Setup calamity details fragment
        CalamityDetailsFragment calamityDetailsFragment = CalamityDetailsFragment.newInstance();
        mCalamityDetailsViewModel = new CalamityDetailsViewModel(getContext());
        calamityDetailsFragment.setViewModel(mCalamityDetailsViewModel);
        mAdapter.addFragment(calamityDetailsFragment);

        // Setup calamity population data fragment
        PopulationDataFragment populationDataFragment = PopulationDataFragment.newInstance();
        mPopulationDataViewModel = new PopulationDataViewModel(getContext());
        populationDataFragment.setViewModel(mPopulationDataViewModel);
        mAdapter.addFragment(populationDataFragment);

        // Initialize viewPager
        mPager = root.findViewById(R.id.nd_gen_info_pager);
        mPager.setAdapter(mAdapter);

        return root;
    }

}

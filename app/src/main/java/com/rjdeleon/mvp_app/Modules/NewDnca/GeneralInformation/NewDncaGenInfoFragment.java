package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewDncaGenInfoFragmentBinding;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaGenInfoFragment extends Fragment {

    public static final String NEW_DNCA_GEN_INFO_CALAMITY_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_CALAMITY_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_POPULATION_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_POPULATION_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_FAMILY_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_FAMILY_VIEWMODEL_TAG";

    private NewDncaGenInfoViewModel mViewModel;
    private NewDncaGenInfoFragmentBinding mBinding;

    private NewDncaGenInfoFragmentAdapter mAdapter;
    private ViewPager mPager;

    public static NewDncaGenInfoFragment newInstance() {
        return new NewDncaGenInfoFragment();
    }

    public NewDncaGenInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the view model
     * @param viewModel
     */
    public void setViewModel(@NonNull NewDncaGenInfoViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.new_dnca_gen_info_fragment, container, false);

        // Bind viewModel to view
        if (mBinding == null) {
            mBinding = NewDncaGenInfoFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        mAdapter = new NewDncaGenInfoFragmentAdapter(getChildFragmentManager());

        {
            // Setup calamity details fragment
            CalamityDetailsFragment calamityDetailsFragment = CalamityDetailsFragment.newInstance();
            CalamityDetailsViewModel calamityDetailsViewModel = new CalamityDetailsViewModel(getContext().getApplicationContext(), mViewModel);
            calamityDetailsFragment.setViewModel(calamityDetailsViewModel);
            mAdapter.addFragment(calamityDetailsFragment);

            // Bind calamity details viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(calamityDetailsViewModel),
                    NEW_DNCA_GEN_INFO_CALAMITY_VIEWMODEL_TAG);
        }

        {
            // Setup population data fragment
            PopulationDataFragment populationDataFragment = PopulationDataFragment.newInstance();
            PopulationDataViewModel populationDataViewModel = new PopulationDataViewModel(getContext().getApplicationContext(), mViewModel);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);

            // Bind population data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(populationDataViewModel),
                    NEW_DNCA_GEN_INFO_POPULATION_VIEWMODEL_TAG);
        }

        {
            // Setup family data fragment
            FamilyDataFragment familyDataFragment = FamilyDataFragment.newInstance();
            FamilyDataViewModel familyDataViewModel = new FamilyDataViewModel(getContext().getApplicationContext(), mViewModel);
            familyDataFragment.setViewModel(familyDataViewModel);
            mAdapter.addFragment(familyDataFragment);

            // Bind family data viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(familyDataViewModel),
                    NEW_DNCA_GEN_INFO_FAMILY_VIEWMODEL_TAG);
        }

        // Initialize viewPager
        mPager = root.findViewById(R.id.nd_gen_info_pager);
        mPager.setAdapter(mAdapter);

        return root;
    }
}

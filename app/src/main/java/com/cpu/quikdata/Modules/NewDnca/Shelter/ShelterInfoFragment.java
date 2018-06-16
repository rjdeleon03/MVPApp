package com.cpu.quikdata.Modules.NewDnca.Shelter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterAssistanceData.ShelterAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_ASSISTANCE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_GAPS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_HOUSE_DAMAGE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_NEEDS;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterInfoFragment extends BaseMultiPageFragment {

    public static ShelterInfoFragment newInstance() {
        return new ShelterInfoFragment();
    }

    public ShelterInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        ShelterInfoRepositoryManager repositoryManager = (ShelterInfoRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup house damage data fragment
            HouseDamageFragment houseDamageFragment =
                    (HouseDamageFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, SHELTER_HOUSE_DAMAGE);
            houseDamageFragment.setViewModel(
                    (HouseDamageViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, SHELTER_HOUSE_DAMAGE, repositoryManager, appContext));
            mAdapter.addFragment(houseDamageFragment);
        }

        {
            // Setup needs data fragment
            ShelterNeedsFragment shelterNeedsFragment =
                    (ShelterNeedsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, SHELTER_NEEDS);
            shelterNeedsFragment.setViewModel(
                    (ShelterNeedsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, SHELTER_NEEDS, repositoryManager, appContext));
            mAdapter.addFragment(shelterNeedsFragment);
        }

        {
            // Setup coping data fragment
            ShelterCopingDataFragment shelterCopingDataFragment =
                    (ShelterCopingDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, SHELTER_COPING);
            shelterCopingDataFragment.setViewModel(
                    (ShelterCopingDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, SHELTER_COPING, repositoryManager, appContext));
            mAdapter.addFragment(shelterCopingDataFragment);
        }

        {
            // Setup assistance data fragment
            ShelterAssistanceDataFragment shelterAssistanceDataFragment =
                    (ShelterAssistanceDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, SHELTER_ASSISTANCE);
            shelterAssistanceDataFragment.setViewModel(
                    (AssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, SHELTER_ASSISTANCE, repositoryManager, appContext));
            mAdapter.addFragment(shelterAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            ShelterGapsDataFragment shelterGapsDataFragment =
                    (ShelterGapsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, SHELTER_GAPS);
            shelterGapsDataFragment.setViewModel(
                    (ShelterGapsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, SHELTER_GAPS, repositoryManager, appContext));
            mAdapter.addFragment(shelterGapsDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

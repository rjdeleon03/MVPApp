package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.ASSISTANCE;
import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_COPING;
import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_GAPS;
import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_HOUSE_DAMAGE;
import static com.rjdeleon.mvp_app.AppConstants.ShelterInfoComponent.SHELTER_NEEDS;
import static com.rjdeleon.mvp_app.AppConstants.VIEWMODEL_TAG;

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

        // Setup specific repository manager
        ShelterInfoRepositoryManager repositoryManager = (ShelterInfoRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup house damage data fragment
            HouseDamageFragment houseDamageFragment = (HouseDamageFragment)findOrCreateViewFragment(SHELTER_HOUSE_DAMAGE);
            houseDamageFragment.setViewModel((HouseDamageViewModel)findOrCreateViewModel(SHELTER_HOUSE_DAMAGE));
            mAdapter.addFragment(houseDamageFragment);
        }

        {
            // Setup needs data fragment
            ShelterNeedsFragment shelterNeedsFragment = (ShelterNeedsFragment)findOrCreateViewFragment(SHELTER_NEEDS);
            shelterNeedsFragment.setViewModel((ShelterNeedsViewModel)findOrCreateViewModel(SHELTER_NEEDS));
            mAdapter.addFragment(shelterNeedsFragment);
        }

        {
            // Setup coping data fragment
            ShelterCopingDataFragment shelterCopingDataFragment = (ShelterCopingDataFragment)findOrCreateViewFragment(SHELTER_COPING);
            shelterCopingDataFragment.setViewModel((ShelterCopingDataViewModel)findOrCreateViewModel(SHELTER_COPING));
            mAdapter.addFragment(shelterCopingDataFragment);
        }

        {
            // Setup assistance data fragment
            AssistanceDataFragment assistanceDataFragment = (AssistanceDataFragment)findOrCreateViewFragment(ASSISTANCE);
            assistanceDataFragment.setViewModel((AssistanceDataViewModel)findOrCreateViewModel(ASSISTANCE));
            mAdapter.addFragment(assistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            ShelterGapsDataFragment shelterGapsDataFragment = (ShelterGapsDataFragment)findOrCreateViewFragment(SHELTER_GAPS);
            shelterGapsDataFragment.setViewModel((ShelterGapsDataViewModel)findOrCreateViewModel(SHELTER_GAPS));
            mAdapter.addFragment(shelterGapsDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

    /**
     * Finds the fragment of the specified type;
     * Creates the fragment if it does not exist
     * @param fragmentType
     * @return
     */
    @NonNull
    private Fragment findOrCreateViewFragment(AppConstants.ShelterInfoComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(getChildFragmentManager(), fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {
                case SHELTER_HOUSE_DAMAGE:
                    selectedFragment = HouseDamageFragment.newInstance();
                    break;
                case SHELTER_NEEDS:
                    selectedFragment = ShelterNeedsFragment.newInstance();
                    break;
                case SHELTER_COPING:
                    selectedFragment = ShelterCopingDataFragment.newInstance();
                    break;
                case ASSISTANCE:
                    selectedFragment = AssistanceDataFragment.newInstance();
                    break;
                case SHELTER_GAPS:
                    selectedFragment = ShelterGapsDataFragment.newInstance();
                    break;
            }
        }
        return selectedFragment;
    }

    /**
     * Finds the viewModel of the specified type;
     * Creates the viewModel if it does not exist
     * @param fragmentType
     * @return
     */
    @NonNull
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.ShelterInfoComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);

        // Setup specific repository manager
        ShelterInfoRepositoryManager repositoryManager = (ShelterInfoRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case SHELTER_HOUSE_DAMAGE:
                    viewModel = new HouseDamageViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case SHELTER_NEEDS:
                    viewModel = new ShelterNeedsViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case SHELTER_COPING:
                    viewModel = new ShelterCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case SHELTER_GAPS:
                    viewModel = new ShelterGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

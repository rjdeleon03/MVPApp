package com.rjdeleon.mvp_app.Modules.NewDnca.Health;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.GenericCopingData.GenericCopingDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthAssistanceData.HealthAssistanceDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.PsychosocialFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.PsychosocialViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsViewModel;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_ASSISTANCE;
import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_COPING;
import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_DISEASES;
import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_GAPS;
import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_PSYCHOSOCIAL;
import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_SPECIAL_NEEDS;
import static com.rjdeleon.mvp_app.AppConstants.VIEWMODEL_TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends BaseMultiPageFragment {

    public static HealthFragment newInstance() {
        return new HealthFragment();
    }

    public HealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = super.onCreateView(inflater, container, savedInstanceState);

        // Setup specific repository manager
        HealthRepositoryManager repositoryManager = (HealthRepositoryManager) mViewModel;
        if (repositoryManager == null) {
            return root;
        }

        {
            // Setup diseases and injuries fragment
            DiseasesInjuriesFragment diseasesInjuriesFragment = (DiseasesInjuriesFragment)findOrCreateViewFragment(HEALTH_DISEASES);
            diseasesInjuriesFragment.setViewModel((DiseasesInjuriesViewModel) findOrCreateViewModel(HEALTH_DISEASES));
            mAdapter.addFragment(diseasesInjuriesFragment);
        }

        {
            // Setup special needs fragment
            SpecialNeedsFragment specialNeedsFragment = (SpecialNeedsFragment)findOrCreateViewFragment(HEALTH_SPECIAL_NEEDS);
            specialNeedsFragment.setViewModel((SpecialNeedsViewModel) findOrCreateViewModel(HEALTH_SPECIAL_NEEDS));
            mAdapter.addFragment(specialNeedsFragment);
        }

        {
            // Setup psychosocial fragment
            PsychosocialFragment psychosocialFragment = (PsychosocialFragment)findOrCreateViewFragment(HEALTH_PSYCHOSOCIAL);
            psychosocialFragment.setViewModel((PsychosocialViewModel) findOrCreateViewModel(HEALTH_PSYCHOSOCIAL));
            mAdapter.addFragment(psychosocialFragment);
        }

        {
            // Setup coping data fragment
            HealthCopingDataFragment healthCopingDataFragment = (HealthCopingDataFragment)findOrCreateViewFragment(HEALTH_COPING);
            healthCopingDataFragment.setViewModel((GenericCopingDataViewModel) findOrCreateViewModel(HEALTH_COPING));
            mAdapter.addFragment(healthCopingDataFragment);
        }

        {
            // Setup assistance data fragment
            HealthAssistanceDataFragment healthAssistanceDataFragment = (HealthAssistanceDataFragment)findOrCreateViewFragment(HEALTH_ASSISTANCE);
            healthAssistanceDataFragment.setViewModel((AssistanceDataViewModel)findOrCreateViewModel(HEALTH_ASSISTANCE));
            mAdapter.addFragment(healthAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            HealthGapsDataFragment healthGapsDataFragment = (HealthGapsDataFragment)findOrCreateViewFragment(HEALTH_GAPS);
            healthGapsDataFragment.setViewModel((HealthGapsDataViewModel) findOrCreateViewModel(HEALTH_GAPS));
            mAdapter.addFragment(healthGapsDataFragment);
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
    private Fragment findOrCreateViewFragment(AppConstants.HealthComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(getChildFragmentManager(), fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {
                case HEALTH_DISEASES:
                    selectedFragment = DiseasesInjuriesFragment.newInstance();
                    break;
                case HEALTH_SPECIAL_NEEDS:
                    selectedFragment = SpecialNeedsFragment.newInstance();
                    break;
                case HEALTH_PSYCHOSOCIAL:
                    selectedFragment = PsychosocialFragment.newInstance();
                    break;
                case HEALTH_COPING:
                    selectedFragment = HealthCopingDataFragment.newInstance();
                    break;
                case HEALTH_ASSISTANCE:
                    selectedFragment = HealthAssistanceDataFragment.newInstance();
                    break;
                case HEALTH_GAPS:
                    selectedFragment = HealthGapsDataFragment.newInstance();
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
    private NewDncaBaseViewModel findOrCreateViewModel(AppConstants.HealthComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getChildFragmentManager().findFragmentByTag(tag);

        // Setup specific repository manager
        HealthRepositoryManager repositoryManager = (HealthRepositoryManager) mViewModel;

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case HEALTH_DISEASES:
                    viewModel = new DiseasesInjuriesViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case HEALTH_SPECIAL_NEEDS:
                    viewModel = new SpecialNeedsViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case HEALTH_PSYCHOSOCIAL:
                    viewModel = new PsychosocialViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case HEALTH_COPING:
                    viewModel = new GenericCopingDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case HEALTH_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
                case HEALTH_GAPS:
                    viewModel = new HealthGapsDataViewModel(getContext().getApplicationContext(), repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(getChildFragmentManager(), retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }

}

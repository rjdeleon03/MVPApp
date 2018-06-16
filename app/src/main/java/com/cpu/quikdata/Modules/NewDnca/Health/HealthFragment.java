package com.cpu.quikdata.Modules.NewDnca.Health;


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
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthAssistanceData.HealthAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsViewModel;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_ASSISTANCE;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_COPING;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_DISEASES;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_GAPS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_PSYCHOSOCIAL;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_SPECIAL_NEEDS;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

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

        if (mViewModel == null) {
            return root;
        }

        // Setup specific repository manager
        HealthRepositoryManager repositoryManager = (HealthRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup diseases and injuries fragment
            DiseasesInjuriesFragment diseasesInjuriesFragment = 
                    (DiseasesInjuriesFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, HEALTH_DISEASES);
            diseasesInjuriesFragment.setViewModel(
                    (DiseasesInjuriesViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, HEALTH_DISEASES, repositoryManager, appContext));
            mAdapter.addFragment(diseasesInjuriesFragment);
        }

        {
            // Setup special needs fragment
            SpecialNeedsFragment specialNeedsFragment = 
                    (SpecialNeedsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, HEALTH_SPECIAL_NEEDS);
            specialNeedsFragment.setViewModel(
                    (SpecialNeedsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, HEALTH_SPECIAL_NEEDS, repositoryManager, appContext));
            mAdapter.addFragment(specialNeedsFragment);
        }

        {
            // Setup psychosocial fragment
            PsychosocialFragment psychosocialFragment = 
                    (PsychosocialFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, HEALTH_PSYCHOSOCIAL);
            psychosocialFragment.setViewModel(
                    (PsychosocialViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, HEALTH_PSYCHOSOCIAL, repositoryManager, appContext));
            mAdapter.addFragment(psychosocialFragment);
        }

        {
            // Setup coping data fragment
            HealthCopingDataFragment healthCopingDataFragment = 
                    (HealthCopingDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, HEALTH_COPING);
            healthCopingDataFragment.setViewModel(
                    (HealthCopingDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, HEALTH_COPING, repositoryManager, appContext));
            mAdapter.addFragment(healthCopingDataFragment);
        }

        {
            // Setup assistance data fragment
            HealthAssistanceDataFragment healthAssistanceDataFragment = 
                    (HealthAssistanceDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, HEALTH_ASSISTANCE);
            healthAssistanceDataFragment.setViewModel(
                    (AssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, HEALTH_ASSISTANCE, repositoryManager, appContext));
            mAdapter.addFragment(healthAssistanceDataFragment);
        }

        {
            // Setup gaps data fragment
            HealthGapsDataFragment healthGapsDataFragment = 
                    (HealthGapsDataFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, HEALTH_GAPS);
            healthGapsDataFragment.setViewModel(
                    (HealthGapsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, HEALTH_GAPS, repositoryManager, appContext));
            mAdapter.addFragment(healthGapsDataFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Health;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjdeleon.mvp_app.Models.Health.HealthGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.PsychosocialFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.PsychosocialViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends BaseMultiPageFragment {

    public static final String NEW_DNCA_HEALTH_DISEASES_INJURIES_VIEWMODEL_TAG = "NEW_DNCA_HEALTH_DISEASES_INJURIES_VIEWMODEL_TAG";
    public static final String NEW_DNCA_HEALTH_SPECIAL_NEEDS_VIEWMODEL_TAG = "NEW_DNCA_HEALTH_SPECIAL_NEEDS_VIEWMODEL_TAG";

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
            DiseasesInjuriesFragment diseasesInjuriesFragment = DiseasesInjuriesFragment.newInstance();
            DiseasesInjuriesViewModel diseasesInjuriesViewModel = new DiseasesInjuriesViewModel(getContext().getApplicationContext(), repositoryManager);
            diseasesInjuriesFragment.setViewModel(diseasesInjuriesViewModel);
            mAdapter.addFragment(diseasesInjuriesFragment);

            // Bind diseases and injuries viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(diseasesInjuriesViewModel),
                    NEW_DNCA_HEALTH_DISEASES_INJURIES_VIEWMODEL_TAG);
        }

        {
            // Setup special needs fragment
            SpecialNeedsFragment specialNeedsFragment = SpecialNeedsFragment.newInstance();
            SpecialNeedsViewModel specialNeedsViewModel = new SpecialNeedsViewModel(getContext().getApplicationContext(), repositoryManager);
            specialNeedsFragment.setViewModel(specialNeedsViewModel);
            mAdapter.addFragment(specialNeedsFragment);

            // Bind special needs viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(specialNeedsViewModel),
                    NEW_DNCA_HEALTH_SPECIAL_NEEDS_VIEWMODEL_TAG);
        }

        {
            // Setup psychosocial fragment
            PsychosocialFragment psychosocialFragment = PsychosocialFragment.newInstance();
            PsychosocialViewModel psychosocialViewModel = new PsychosocialViewModel(getContext().getApplicationContext(), repositoryManager);
            psychosocialFragment.setViewModel(psychosocialViewModel);
            mAdapter.addFragment(psychosocialFragment);

            // Bind psychosocial viewModel to root activity's lifecycle
            ActivityUtils.addFragmentToActivity(getChildFragmentManager(),
                    ViewModelHolder.createContainer(psychosocialViewModel),
                    NEW_DNCA_HEALTH_SPECIAL_NEEDS_VIEWMODEL_TAG);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }

}

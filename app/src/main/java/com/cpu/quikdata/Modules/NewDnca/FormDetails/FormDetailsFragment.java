package com.cpu.quikdata.Modules.NewDnca.FormDetails;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails.GenFormDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails.GenFormDetailsViewModel;
import com.cpu.quikdata.ViewFactory;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FORM_GEN_FORM_DETAILS;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormDetailsFragment extends BaseMultiPageFragment {

    public static FormDetailsFragment newInstance() {
        return new FormDetailsFragment();
    }

    public FormDetailsFragment() {
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
        FormDetailsRepositoryManager repositoryManager = (FormDetailsRepositoryManager) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup evacuation site data fragment
            GenFormDetailsFragment genFormDetailsFragment =
                    (GenFormDetailsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FORM_GEN_FORM_DETAILS);
            genFormDetailsFragment.setViewModel(
                    (GenFormDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, FORM_GEN_FORM_DETAILS, repositoryManager, appContext));
            mAdapter.addFragment(genFormDetailsFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

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
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsViewModel;
import com.cpu.quikdata.ViewFactory;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FORM_GEN_FORM_DETAILS;
import static com.cpu.quikdata.AppConstants.NewDncaComponent.FORM_INTERVIEW_DETAILS;

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
        IFormDetailsViewModel repositoryManager = (IFormDetailsViewModel) mViewModel;

        // Obtain fragment manager and context
        FragmentManager fragmentManager = getChildFragmentManager();
        Context appContext = getContext().getApplicationContext();

        {
            // Setup general form details fragment
            GenFormDetailsFragment genFormDetailsFragment =
                    (GenFormDetailsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FORM_GEN_FORM_DETAILS);
            genFormDetailsFragment.setViewModel(
                    (GenFormDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, FORM_GEN_FORM_DETAILS, repositoryManager, appContext));
            mAdapter.addFragment(genFormDetailsFragment);
        }

        {
            // Setup interview details fragment
            InterviewDetailsFragment interviewDetailsFragment =
                    (InterviewDetailsFragment) ViewFactory.findOrCreateViewFragment(fragmentManager, FORM_INTERVIEW_DETAILS);
            interviewDetailsFragment.setViewModel(
                    (InterviewDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, FORM_INTERVIEW_DETAILS, repositoryManager, appContext));
            mAdapter.addFragment(interviewDetailsFragment);
        }

        // Call to parent class to setup the view pager
        super.setupViewPager(root);

        return root;
    }
}

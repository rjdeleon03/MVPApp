package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails.ShelterCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails.ShelterCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails.ShelterGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails.ShelterGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData.ShelterNeedsDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData.ShelterNeedsDataViewModel;
import com.cpu.quikdata.ViewFactory;

public class ShelterInformationFragment extends TemplateMultiPageFragment<ShelterInformationViewModel> {

    public ShelterInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_INFO.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterInformationFragment newInstance() {
        return new ShelterInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {
        FragmentManager fragmentManager = getChildFragmentManager();
        
        {
            // Setup damage data fragment
            DamageDataFragment damageDataFragment =
                    (DamageDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_DAMAGE);
            DamageDataViewModel damageDataViewModel =
                    (DamageDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_DAMAGE, null, getContext());
            damageDataViewModel.setViewComponent(damageDataFragment);
            damageDataFragment.setViewModel(damageDataViewModel);
            mAdapter.addFragment(damageDataFragment);
        }

        {
            // Setup shelter coping details fragment
            ShelterCopingDetailsFragment shelterCopingDetailsFragment =
                    (ShelterCopingDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_COPING);
            shelterCopingDetailsFragment.setViewModel(
                    (ShelterCopingDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_COPING, null, getContext()));
            mAdapter.addFragment(shelterCopingDetailsFragment);
        }

        {
            // Setup shelter needs data fragment
            ShelterNeedsDataFragment shelterNeedsDataFragment =
                    (ShelterNeedsDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_NEEDS);
            ShelterNeedsDataViewModel shelterNeedsDataViewModel =
                    (ShelterNeedsDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_NEEDS, null, getContext());
            shelterNeedsDataViewModel.setViewComponent(shelterNeedsDataFragment);
            shelterNeedsDataFragment.setViewModel(shelterNeedsDataViewModel);
            mAdapter.addFragment(shelterNeedsDataFragment);
        }

        {
            // Setup shelter gaps details fragment
            ShelterGapsDetailsFragment shelterGapsDetailsFragment =
                    (ShelterGapsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_GAPS);
            shelterGapsDetailsFragment.setViewModel(
                    (ShelterGapsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_GAPS, null, getContext()));
            mAdapter.addFragment(shelterGapsDetailsFragment);
        }
    }
}

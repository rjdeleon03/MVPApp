package com.cpu.quikdata.ModulesV2.NewForm.WashInformation;

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
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails.WashConditionsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails.WashConditionsDetailsViewModel;
import com.cpu.quikdata.ViewFactory;

public class WashInformationFragment extends TemplateMultiPageFragment<WashInformationViewModel> {

    public WashInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.WASH.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static WashInformationFragment newInstance() {
        return new WashInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {
        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup wash conditions details fragment
            WashConditionsDetailsFragment washConditionsDetailsFragment =
                    (WashConditionsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.WASH_CONDITIONS);
            washConditionsDetailsFragment.setViewModel(
                    (WashConditionsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.WASH_CONDITIONS, null, getContext()));
            mAdapter.addFragment(washConditionsDetailsFragment);
        }
        
        /**
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
         */
    }
}

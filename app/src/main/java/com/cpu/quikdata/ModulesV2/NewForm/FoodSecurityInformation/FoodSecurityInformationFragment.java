package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityAssistanceData.FoodSecurityAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityAssistanceData.FoodSecurityAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityCopingDetails.FoodSecurityCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityCopingDetails.FoodSecurityCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityGapsDetails.FoodSecurityGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityGapsDetails.FoodSecurityGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityNeedsDetails.FoodSecurityNeedsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityNeedsDetails.FoodSecurityNeedsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.ImpactDetails.ImpactDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.ImpactDetails.ImpactDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData.CasualtiesDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData.CasualtiesDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData.DeathCauseDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData.DeathCauseDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails.FamilyDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails.FamilyDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData.InfrastructureDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData.InfrastructureDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.PopulationDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData.VulnerableDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData.VulnerableDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ViewFactory;

public class FoodSecurityInformationFragment extends TemplateMultiPageFragment<FoodSecurityInformationViewModel> {

    public FoodSecurityInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.FOOD_SECURITY.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static FoodSecurityInformationFragment newInstance() {
        return new FoodSecurityInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {

        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup impact details fragment
            ImpactDetailsFragment impactDetailsFragment =
                    (ImpactDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_IMPACT);
            impactDetailsFragment.setViewModel(
                    (ImpactDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_IMPACT, null, getContext()));
            mAdapter.addFragment(impactDetailsFragment);
        }
        
        {
            // Setup food security coping details fragment
            FoodSecurityCopingDetailsFragment foodSecurityCopingDetailsFragment =
                    (FoodSecurityCopingDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_COPING);
            foodSecurityCopingDetailsFragment.setViewModel(
                    (FoodSecurityCopingDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_COPING, null, getContext()));
            mAdapter.addFragment(foodSecurityCopingDetailsFragment);
        }
        
        {
            // Setup food security needs details fragment
            FoodSecurityNeedsDetailsFragment foodSecurityNeedsDetailsFragment =
                    (FoodSecurityNeedsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_NEEDS);
            foodSecurityNeedsDetailsFragment.setViewModel(
                    (FoodSecurityNeedsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_NEEDS, null, getContext()));
            mAdapter.addFragment(foodSecurityNeedsDetailsFragment);
        }

        {
            // Setup food security assistance data fragment
            FoodSecurityAssistanceDataFragment foodSecurityAssistanceDataFragment =
                    (FoodSecurityAssistanceDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_ASSISTANCE);
            FoodSecurityAssistanceDataViewModel foodSecurityAssistanceDataViewModel =
                    (FoodSecurityAssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_ASSISTANCE, null, getContext());
            foodSecurityAssistanceDataViewModel.setViewComponent(foodSecurityAssistanceDataFragment);
            foodSecurityAssistanceDataFragment.setViewModel(foodSecurityAssistanceDataViewModel);
            mAdapter.addFragment(foodSecurityAssistanceDataFragment);
        }
        
        {
            // Setup food security gaps details fragment
            FoodSecurityGapsDetailsFragment foodSecurityGapsDetailsFragment =
                    (FoodSecurityGapsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_GAPS);
            foodSecurityGapsDetailsFragment.setViewModel(
                    (FoodSecurityGapsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.FOOD_SECURITY_GAPS, null, getContext()));
            mAdapter.addFragment(foodSecurityGapsDetailsFragment);
        }
    }
}
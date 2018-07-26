package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsAssistanceData.LivelihoodsAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsAssistanceData.LivelihoodsAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsCopingDetails.LivelihoodsCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsCopingDetails.LivelihoodsCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsGapsDetails.LivelihoodsGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsGapsDetails.LivelihoodsGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsNeedsDetails.LivelihoodsNeedsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsNeedsDetails.LivelihoodsNeedsDetailsViewModel;
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

public class LivelihoodsInformationFragment extends TemplateMultiPageFragment<LivelihoodsInformationViewModel> {

    public LivelihoodsInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static LivelihoodsInformationFragment newInstance() {
        return new LivelihoodsInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {
        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup livelihoods coping details fragment
            LivelihoodsCopingDetailsFragment livelihoodsCopingDetailsFragment =
                    (LivelihoodsCopingDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_COPING);
            livelihoodsCopingDetailsFragment.setViewModel(
                    (LivelihoodsCopingDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_COPING, null, getContext()));
            mAdapter.addFragment(livelihoodsCopingDetailsFragment);
        }

        {
            // Setup livelihoods needs details fragment
            LivelihoodsNeedsDetailsFragment livelihoodsNeedsDetailsFragment =
                    (LivelihoodsNeedsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_NEEDS);
            livelihoodsNeedsDetailsFragment.setViewModel(
                    (LivelihoodsNeedsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_NEEDS, null, getContext()));
            mAdapter.addFragment(livelihoodsNeedsDetailsFragment);
        }

        {
            // Setup livelihoods assistance data fragment
            LivelihoodsAssistanceDataFragment livelihoodsAssistanceDataFragment =
                    (LivelihoodsAssistanceDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_ASSISTANCE);
            LivelihoodsAssistanceDataViewModel livelihoodsAssistanceDataViewModel =
                    (LivelihoodsAssistanceDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_ASSISTANCE, null, getContext());
            livelihoodsAssistanceDataViewModel.setViewComponent(livelihoodsAssistanceDataFragment);
            livelihoodsAssistanceDataFragment.setViewModel(livelihoodsAssistanceDataViewModel);
            mAdapter.addFragment(livelihoodsAssistanceDataFragment);
        }

        {
            // Setup livelihoods gaps details fragment
            LivelihoodsGapsDetailsFragment livelihoodsGapsDetailsFragment =
                    (LivelihoodsGapsDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_GAPS);
            livelihoodsGapsDetailsFragment.setViewModel(
                    (LivelihoodsGapsDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.LIVELIHOODS_GAPS, null, getContext()));
            mAdapter.addFragment(livelihoodsGapsDetailsFragment);
        }
    }
}

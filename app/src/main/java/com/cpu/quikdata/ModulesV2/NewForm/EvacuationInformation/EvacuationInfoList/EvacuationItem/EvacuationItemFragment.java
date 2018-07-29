package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationCenterDetails.EvacuationCenterDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationCenterDetails.EvacuationCenterDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationFacilitiesDetails.EvacuationFacilitiesDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationFacilitiesDetails.EvacuationFacilitiesDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationPopulationData.EvacuationPopulationDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationPopulationData.EvacuationPopulationDataViewModel;
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

public class EvacuationItemFragment extends TemplateMultiPageFragment<EvacuationItemViewModel> {

    public EvacuationItemFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationItemFragment newInstance() {
        return new EvacuationItemFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {

        FragmentManager fragmentManager = getChildFragmentManager();

        {
            // Setup evacuation center details fragment
            EvacuationCenterDetailsFragment evacuationCenterDetailsFragment =
                    (EvacuationCenterDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM_CENTER);
            EvacuationCenterDetailsViewModel evacuationCenterDetailsViewModel =
                    (EvacuationCenterDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM_CENTER, null, getContext());
            evacuationCenterDetailsViewModel.setDataManager(mViewModel);
            evacuationCenterDetailsFragment.setViewModel(evacuationCenterDetailsViewModel);
            mAdapter.addFragment(evacuationCenterDetailsFragment);
        }

        {
            // Setup evacuation facilities details fragment
            EvacuationFacilitiesDetailsFragment evacuationFacilitiesDetailsFragment =
                    (EvacuationFacilitiesDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM_FACILITIES);
            EvacuationFacilitiesDetailsViewModel evacuationFacilitiesDetailsViewModel =
                    (EvacuationFacilitiesDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM_FACILITIES, null, getContext());
            evacuationFacilitiesDetailsViewModel.setDataManager(mViewModel);
            evacuationFacilitiesDetailsFragment.setViewModel(evacuationFacilitiesDetailsViewModel);
            mAdapter.addFragment(evacuationFacilitiesDetailsFragment);
        }

        {
            // Setup evacuation population data fragment
            EvacuationPopulationDataFragment evacuationPopulationDataFragment =
                    (EvacuationPopulationDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM_POPULATION);
            EvacuationPopulationDataViewModel evacuationPopulationDataViewModel =
                    (EvacuationPopulationDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.EVACUATION_ITEM_POPULATION, null, getContext());
            evacuationPopulationDataViewModel.setDataManager(mViewModel);
            evacuationPopulationDataViewModel.setViewComponent(evacuationPopulationDataFragment);
            evacuationPopulationDataFragment.setViewModel(evacuationPopulationDataViewModel);
            mAdapter.addFragment(evacuationPopulationDataFragment);
        }
        /**
        {
            // Setup calamity details fragment
            EvacuationFacilitiesDetailsFragment calamityDetailsFragment =
                    (EvacuationFacilitiesDetailsFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY);
            calamityDetailsFragment.setViewModel(
                    (EvacuationFacilitiesDetailsViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_CALAMITY, null, getContext()));
            mAdapter.addFragment(calamityDetailsFragment);
        }
        {
            // Setup population data fragment
            EvacuationPopulationDataFragment populationDataFragment =
                    (EvacuationPopulationDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_POPULATION);
            EvacuationPopulationDataViewModel populationDataViewModel =
                    (EvacuationPopulationDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.GEN_INFO_POPULATION, null, getContext());
            populationDataViewModel.setViewComponent(populationDataFragment);
            populationDataFragment.setViewModel(populationDataViewModel);
            mAdapter.addFragment(populationDataFragment);
        }
        */
    }
}

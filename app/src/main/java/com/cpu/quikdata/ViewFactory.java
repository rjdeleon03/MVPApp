package com.cpu.quikdata;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.cpu.quikdata.Modules.DNCAList.DNCAListActivity;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.AssistanceDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData.EvacuationCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData.EvacuationCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData.EvacuationFacilitiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData.EvacuationFacilitiesDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemActivity;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData.EvacuationSecurityDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData.EvacuationSecurityDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData.EvacuationSiteDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData.EvacuationSiteDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData.EvacuationWashDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData.EvacuationWashDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationListFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationListViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodAssistanceData.FoodAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodCopingData.FoodCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodCopingData.FoodCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodGapsData.FoodGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodGapsData.FoodGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodImpactData.FoodImpactDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodNeedsData.FoodNeedsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodNeedsData.FoodNeedsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails.GenFormDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails.GenFormDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthAssistanceData.HealthAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsAssistanceData.LivelihoodsAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsCopingData.LivelihoodsCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsCopingData.LivelihoodsCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsGapsData.LivelihoodsGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsGapsData.LivelihoodsGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeAfterFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeBeforeFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.LivelihoodsIncomeViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData.LivelihoodsNeedsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData.LivelihoodsNeedsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.NewDncaActivity;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterAssistanceData.ShelterAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashAssistanceData.WashAssistanceDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashRepositoryManager;
import com.cpu.quikdata.Utils.ActivityUtils;

import static com.cpu.quikdata.AppConstants.REQUEST_IMAGE_CAPTURE;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

public class ViewFactory {

    public static void startDNCAListActivity(Context context) {
        Intent intent = new Intent(context, DNCAListActivity.class);
        context.startActivity(intent);
    }

    public static void startNewDncaActivity(Context context) {
        Intent intent = new Intent(context, NewDncaActivity.class);
        context.startActivity(intent);
    }

    public static void startCameraActivity(AppCompatActivity activity) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public static void startEvacuationItemActivity(AppCompatActivity activity) {
        Intent intent = new Intent(activity, EvacuationItemActivity.class);
        activity.startActivity(intent);
    }

    /**
     * Finds the fragment of the specified type;
     * Creates the fragment if it does not exist
     * @param fragmentType
     * @return
     */
    @NonNull
    public static Fragment findOrCreateViewFragment(FragmentManager fragmentManager, AppConstants.NewDncaComponent fragmentType) {
        BaseSubFragment selectedFragment = ActivityUtils.findSubFragment(fragmentManager, fragmentType.toString());
        if (selectedFragment == null) {
            switch(fragmentType) {

                // Form Details
                case FORM_GEN_FORM_DETAILS:
                    selectedFragment = GenFormDetailsFragment.newInstance();
                    break;
                case FORM_INTERVIEW_DETAILS:
                    selectedFragment = InterviewDetailsFragment.newInstance();
                    break;

                // General Information
                case GEN_INFO_CALAMITY:
                    selectedFragment = CalamityDetailsFragment.newInstance();
                    break;
                case GEN_INFO_POPULATION:
                    selectedFragment = PopulationDataFragment.newInstance();
                    break;
                case GEN_INFO_FAMILY:
                    selectedFragment = FamilyDataFragment.newInstance();
                    break;
                case GEN_INFO_VULNERABLE:
                    selectedFragment = VulnerablePopulationFragment.newInstance();
                    break;
                case GEN_INFO_CASUALTIES:
                    selectedFragment = CasualtiesDataFragment.newInstance();
                    break;
                case GEN_INFO_DEATH_CAUSE:
                    selectedFragment = DeathCauseDataFragment.newInstance();
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    selectedFragment = InfrastructureDamageFragment.newInstance();
                    break;

                // Shelter and Non-Food Items
                case SHELTER_HOUSE_DAMAGE:
                    selectedFragment = HouseDamageFragment.newInstance();
                    break;
                case SHELTER_NEEDS:
                    selectedFragment = ShelterNeedsFragment.newInstance();
                    break;
                case SHELTER_COPING:
                    selectedFragment = ShelterCopingDataFragment.newInstance();
                    break;
                case SHELTER_ASSISTANCE:
                    selectedFragment = ShelterAssistanceDataFragment.newInstance();
                    break;
                case SHELTER_GAPS:
                    selectedFragment = ShelterGapsDataFragment.newInstance();
                    break;

                // Food Security
                case FOOD_IMPACT:
                    selectedFragment = FoodImpactDataFragment.newInstance();
                    break;
                case FOOD_COPING:
                    selectedFragment = FoodCopingDataFragment.newInstance();
                    break;
                case FOOD_NEEDS:
                    selectedFragment = FoodNeedsDataFragment.newInstance();
                    break;
                case FOOD_ASSISTANCE:
                    selectedFragment = FoodAssistanceDataFragment.newInstance();
                    break;
                case FOOD_GAPS:
                    selectedFragment = FoodGapsDataFragment.newInstance();
                    break;

                // Livelihoods
                case LIVELIHOODS_INCOME_BEFORE:
                    selectedFragment = LivelihoodsIncomeBeforeFragment.newInstance();
                    break;
                case LIVELIHOODS_INCOME_AFTER:
                    selectedFragment = LivelihoodsIncomeAfterFragment.newInstance();
                    break;
                case LIVELIHOODS_DAMAGE:
                    selectedFragment = LivelihoodsDamageFragment.newInstance();
                    break;
                case LIVELIHOODS_COPING:
                    selectedFragment = LivelihoodsCopingDataFragment.newInstance();
                    break;
                case LIVELIHOODS_NEEDS:
                    selectedFragment = LivelihoodsNeedsDataFragment.newInstance();
                    break;
                case LIVELIHOODS_ASSISTANCE:
                    selectedFragment = LivelihoodsAssistanceDataFragment.newInstance();
                    break;
                case LIVELIHOODS_GAPS:
                    selectedFragment = LivelihoodsGapsDataFragment.newInstance();
                    break;
                    
                // Health
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

                // Water, Sanitation, and Hygiene
                case WASH_CONDITIONS:
                    selectedFragment = WashConditionsFragment.newInstance();
                    break;
                case WASH_COPING:
                    selectedFragment = WashCopingDataFragment.newInstance();
                    break;
                case WASH_ASSISTANCE:
                    selectedFragment = WashAssistanceDataFragment.newInstance();
                    break;
                case WASH_GAPS:
                    selectedFragment = WashGapsDataFragment.newInstance();
                    break;

                // Evacuation Centers
                case EVACUATION_SITE:
                    selectedFragment = EvacuationSiteDataFragment.newInstance();
                    break;
                case EVACUATION_POPULATION:
                    selectedFragment = EvacuationPopulationFragment.newInstance();
                    break;
                case EVACUATION_FACILITIES:
                    selectedFragment = EvacuationFacilitiesDataFragment.newInstance();
                    break;
                case EVACUATION_WASH:
                    selectedFragment = EvacuationWashDataFragment.newInstance();
                    break;
                case EVACUATION_SECURITY:
                    selectedFragment = EvacuationSecurityDataFragment.newInstance();
                    break;
                case EVACUATION_COPING:
                    selectedFragment = EvacuationCopingDataFragment.newInstance();
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
    public static NewDncaBaseViewModel findOrCreateViewModel(FragmentManager fragmentManager,
                                                              AppConstants.NewDncaComponent fragmentType,
                                                              Object repositoryManager,
                                                              Context context) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) fragmentManager.findFragmentByTag(tag);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {

                // Form Details
                case FORM_GEN_FORM_DETAILS:
                    viewModel = new GenFormDetailsViewModel(context, (FormDetailsRepositoryManager) repositoryManager);
                    break;
                case FORM_INTERVIEW_DETAILS:
                    viewModel = new InterviewDetailsViewModel(context, (FormDetailsRepositoryManager) repositoryManager);
                    break;

                // General Information
                case GEN_INFO_CALAMITY:
                    viewModel = new CalamityDetailsViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_POPULATION:
                    viewModel = new PopulationDataViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_FAMILY:
                    viewModel = new FamilyDataViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_VULNERABLE:
                    viewModel = new VulnerablePopulationViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_CASUALTIES:
                    viewModel = new CasualtiesDataViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_DEATH_CAUSE:
                    viewModel = new DeathCauseDataViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    viewModel = new InfrastructureDamageViewModel(context, (GenInfoRepositoryManager)repositoryManager);
                    break;
                    
                // Shelter and Non-Food Items
                case SHELTER_HOUSE_DAMAGE:
                    viewModel = new HouseDamageViewModel(context, (ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_NEEDS:
                    viewModel = new ShelterNeedsViewModel(context, (ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_COPING:
                    viewModel = new ShelterCopingDataViewModel(context, (ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(context, (ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_GAPS:
                    viewModel = new ShelterGapsDataViewModel(context, (ShelterInfoRepositoryManager)repositoryManager);
                    break;
                    
                // Food Security
                case FOOD_IMPACT:
                    viewModel = new FoodImpactDataViewModel(context, (FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_COPING:
                    viewModel = new FoodCopingDataViewModel(context, (FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_NEEDS:
                    viewModel = new FoodNeedsDataViewModel(context, (FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(context, (FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_GAPS:
                    viewModel = new FoodGapsDataViewModel(context, (FoodSecurityRepositoryManager)repositoryManager);
                    break;
                    
                // Livelihoods
                case LIVELIHOODS_INCOME_BEFORE:
                    viewModel = new LivelihoodsIncomeViewModel(context, (LivelihoodsRepositoryManager)repositoryManager, true);
                    break;
                case LIVELIHOODS_INCOME_AFTER:
                    viewModel = new LivelihoodsIncomeViewModel(context, (LivelihoodsRepositoryManager)repositoryManager, false);
                    break;
                case LIVELIHOODS_DAMAGE:
                    viewModel = new LivelihoodsDamageViewModel(context, (LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_COPING:
                    viewModel = new LivelihoodsCopingDataViewModel(context, (LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_NEEDS:
                    viewModel = new LivelihoodsNeedsDataViewModel(context, (LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(context, (LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_GAPS:
                    viewModel = new LivelihoodsGapsDataViewModel(context, (LivelihoodsRepositoryManager)repositoryManager);
                    break;

                // Health
                case HEALTH_DISEASES:
                    viewModel = new DiseasesInjuriesViewModel(context, (HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_SPECIAL_NEEDS:
                    viewModel = new SpecialNeedsViewModel(context, (HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_PSYCHOSOCIAL:
                    viewModel = new PsychosocialViewModel(context, (HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_COPING:
                    viewModel = new HealthCopingDataViewModel(context, (HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(context, (HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_GAPS:
                    viewModel = new HealthGapsDataViewModel(context, (HealthRepositoryManager)repositoryManager);
                    break;
                    
                // Water, Sanitation, and Hygiene
                case WASH_CONDITIONS:
                    viewModel = new WashConditionsViewModel(context, (WashRepositoryManager)repositoryManager);
                    break;
                case WASH_COPING:
                    viewModel = new WashCopingDataViewModel(context, (WashRepositoryManager)repositoryManager);
                    break;
                case WASH_ASSISTANCE:
                    viewModel = new AssistanceDataViewModel(context, (WashRepositoryManager)repositoryManager);
                    break;
                case WASH_GAPS:
                    viewModel = new WashGapsDataViewModel(context, (WashRepositoryManager)repositoryManager);
                    break;

                // Evacuation Centers
                case EVACUATION_SITE:
                    viewModel = new EvacuationSiteDataViewModel(context, (EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_POPULATION:
                    viewModel = new EvacuationPopulationViewModel(context, (EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_FACILITIES:
                    viewModel = new EvacuationFacilitiesDataViewModel(context, (EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_WASH:
                    viewModel = new EvacuationWashDataViewModel(context, (EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_SECURITY:
                    viewModel = new EvacuationSecurityDataViewModel(context, (EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_COPING:
                    viewModel = new EvacuationCopingDataViewModel(context, (EvacuationItemRepositoryManager)repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(fragmentManager, retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

package com.cpu.quikdata;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.cpu.quikdata.Modules.NewDnca.Base.BaseSubFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData.EvacuationCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData.EvacuationCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData.EvacuationFacilitiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData.EvacuationFacilitiesDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData.EvacuationSecurityDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData.EvacuationSecurityDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData.EvacuationSiteDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData.EvacuationSiteDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData.EvacuationWashDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData.EvacuationWashDataViewModel;
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
import com.cpu.quikdata.Modules.NewDnca.FormDetails.IFormDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails.GenFormDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails.GenFormDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData.FamilyDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.InfrastructureDamageViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData.HealthCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData.HealthGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsViewModel;
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
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterCopingData.ShelterCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData.ShelterGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions.WashConditionsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashCopingData.WashCopingDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashGapsData.WashGapsDataViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashRepositoryManager;
import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.FormList.FormListActivity;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityAssistanceData.FoodSecurityAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityAssistanceData.FoodSecurityAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityCopingDetails.FoodSecurityCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityCopingDetails.FoodSecurityCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityGapsDetails.FoodSecurityGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityGapsDetails.FoodSecurityGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityNeedsDetails.FoodSecurityNeedsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityNeedsDetails.FoodSecurityNeedsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.ImpactDetails.ImpactDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.ImpactDetails.ImpactDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData.CasualtiesDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData.CasualtiesDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData.DeathCauseDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData.DeathCauseDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails.FamilyDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails.FamilyDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.GeneralInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.GeneralInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData.InfrastructureDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData.InfrastructureDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.PopulationDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData.VulnerableDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData.VulnerableDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData.DiseasesDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData.DiseasesDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthAssistanceData.HealthAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthAssistanceData.HealthAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthCopingDetails.HealthCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthCopingDetails.HealthCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthGapsDetails.HealthGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthGapsDetails.HealthGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData.PsychosocialDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData.PsychosocialDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData.SpecialNeedsDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData.SpecialNeedsDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.DamageCostData.DamageCostDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.DamageCostData.DamageCostDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataAfter.IncomeSourceDataAfterFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataAfter.IncomeSourceDataAfterViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataBefore.IncomeSourceDataBeforeFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataBefore.IncomeSourceDataBeforeViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsAssistanceData.LivelihoodsAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsAssistanceData.LivelihoodsAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsCopingDetails.LivelihoodsCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsCopingDetails.LivelihoodsCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsGapsDetails.LivelihoodsGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsGapsDetails.LivelihoodsGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsNeedsDetails.LivelihoodsNeedsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsNeedsDetails.LivelihoodsNeedsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterAssistanceData.ShelterAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterAssistanceData.ShelterAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails.ShelterCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails.ShelterCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails.ShelterGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails.ShelterGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData.ShelterNeedsDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData.ShelterNeedsDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashAssistanceData.WashAssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashAssistanceData.WashAssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails.WashConditionsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails.WashConditionsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashCopingDetails.WashCopingDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashCopingDetails.WashCopingDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashGapsDetails.WashGapsDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashGapsDetails.WashGapsDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashInformationViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.PrefilledDataActivity;
import com.cpu.quikdata.Utils.ActivityUtils;

import static com.cpu.quikdata.AppConstants.REQUEST_IMAGE_CAPTURE;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

public class ViewFactory {

    public static void startDNCAListActivity(Context context) {
        Intent intent = new Intent(context, FormListActivity.class);
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

    public static void startPrefilledActivity(Context context) {
        Intent intent = new Intent(context, PrefilledDataActivity.class);
        context.startActivity(intent);
    }

    public static void startNewFormActivity(Context context) {
        Intent intent = new Intent(context, NewFormActivity.class);
        context.startActivity(intent);
    }

    @NonNull
    public static BaseFragment findOrCreateFragment(FragmentManager fragmentManager,
                                                    NewFormActivity.NewFormComponent fragmentType) {

        return findOrCreateFragment(fragmentManager, fragmentType, -1);
    }
    @NonNull
    public static BaseFragment findOrCreateFragment(FragmentManager fragmentManager,
                                                    NewFormActivity.NewFormComponent fragmentType,
                                                    int fragmentContainer) {

        BaseFragment fragment = ActivityUtils.findFragment(fragmentManager, fragmentType.toString());
        boolean addToBackstack = true;

        if (fragment == null) {
            switch (fragmentType) {
                case MENU:
                    fragment = NewFormFragment.newInstance();
                    addToBackstack = false;
                    break;
                case FORM_DETAILS:
                    fragment = FormDetailsFragment.newInstance();
                    break;
                case GEN_INFO:
                    fragment = GeneralInformationFragment.newInstance();
                    break;
                case GEN_INFO_CALAMITY:
                    fragment = CalamityDetailsFragment.newInstance();
                    break;
                case GEN_INFO_POPULATION:
                    fragment = PopulationDataFragment.newInstance();
                    break;
                case GEN_INFO_FAMILY:
                    fragment = FamilyDetailsFragment.newInstance();
                    break;
                case GEN_INFO_VULNERABLE:
                    fragment = VulnerableDataFragment.newInstance();
                    break;
                case GEN_INFO_CASUALTIES:
                    fragment = CasualtiesDataFragment.newInstance();
                    break;
                case GEN_INFO_DEATH_CAUSE:
                    fragment = DeathCauseDataFragment.newInstance();
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    fragment = InfrastructureDataFragment.newInstance();
                    break;
                case SHELTER_INFO:
                    fragment = ShelterInformationFragment.newInstance();
                    break;
                case SHELTER_INFO_DAMAGE:
                    fragment = DamageDataFragment.newInstance();
                    break;
                case SHELTER_INFO_COPING:
                    fragment = ShelterCopingDetailsFragment.newInstance();
                    break;
                case SHELTER_INFO_NEEDS:
                    fragment = ShelterNeedsDataFragment.newInstance();
                    break;
                case SHELTER_ASSISTANCE:
                    fragment = ShelterAssistanceDataFragment.newInstance();
                    break;
                case SHELTER_INFO_GAPS:
                    fragment = ShelterGapsDetailsFragment.newInstance();
                    break;
                case FOOD_SECURITY:
                    fragment = FoodSecurityInformationFragment.newInstance();
                    break;
                case FOOD_SECURITY_IMPACT:
                    fragment = ImpactDetailsFragment.newInstance();
                    break;
                case FOOD_SECURITY_COPING:
                    fragment = FoodSecurityCopingDetailsFragment.newInstance();
                    break;
                case FOOD_SECURITY_NEEDS:
                    fragment = FoodSecurityNeedsDetailsFragment.newInstance();
                    break;
                case FOOD_SECURITY_ASSISTANCE:
                    fragment = FoodSecurityAssistanceDataFragment.newInstance();
                    break;
                case FOOD_SECURITY_GAPS:
                    fragment = FoodSecurityGapsDetailsFragment.newInstance();
                    break;
                case LIVELIHOODS:
                    fragment = LivelihoodsInformationFragment.newInstance();
                    break;
                case LIVELIHOODS_BEFORE:
                    fragment = IncomeSourceDataBeforeFragment.newInstance();
                    break;
                case LIVELIHOODS_AFTER:
                    fragment = IncomeSourceDataAfterFragment.newInstance();
                    break;
                case LIVELIHOODS_DAMAGE:
                    fragment = DamageCostDataFragment.newInstance();
                    break;
                case LIVELIHOODS_COPING:
                    fragment = LivelihoodsCopingDetailsFragment.newInstance();
                    break;
                case LIVELIHOODS_NEEDS:
                    fragment = LivelihoodsNeedsDetailsFragment.newInstance();
                    break;
                case LIVELIHOODS_ASSISTANCE:
                    fragment = LivelihoodsAssistanceDataFragment.newInstance();
                    break;
                case LIVELIHOODS_GAPS:
                    fragment = LivelihoodsGapsDetailsFragment.newInstance();
                    break;
                case HEALTH:
                    fragment = HealthInformationFragment.newInstance();
                    break;
                case HEALTH_DISEASES:
                    fragment = DiseasesDataFragment.newInstance();
                    break;
                case HEALTH_SPECIAL_NEEDS:
                    fragment = SpecialNeedsDataFragment.newInstance();
                    break;
                case HEALTH_PSYCHOSOCIAL:
                    fragment = PsychosocialDataFragment.newInstance();
                    break;
                case HEALTH_COPING:
                    fragment = HealthCopingDetailsFragment.newInstance();
                    break;
                case HEALTH_ASSISTANCE:
                    fragment = HealthAssistanceDataFragment.newInstance();
                    break;
                case HEALTH_GAPS:
                    fragment = HealthGapsDetailsFragment.newInstance();
                    break;
                case WASH:
                    fragment = WashInformationFragment.newInstance();
                    break;
                case WASH_CONDITIONS:
                    fragment = WashConditionsDetailsFragment.newInstance();
                    break;
                case WASH_COPING:
                    fragment = WashCopingDetailsFragment.newInstance();
                    break;
                case WASH_ASSISTANCE:
                    fragment = WashAssistanceDataFragment.newInstance();
                    break;
                case WASH_GAPS:
                    fragment = WashGapsDetailsFragment.newInstance();
                    break;
                    
            }

            // Do not search for view fragment container if id == -1
            if (fragmentContainer != -1) {
                ActivityUtils.addFragmentToActivity(fragmentManager, fragment, fragmentContainer, addToBackstack, fragmentType.toString());
            }
        }
        return fragment;
    }

    @NonNull
    public static BaseViewModel findOrCreateViewModel(FragmentManager fragmentManager,
                                                      NewFormActivity.NewFormComponent fragmentType,
                                                      IBaseInterface baseInterface,
                                                      Context context) {

        String vmTag = fragmentType.toString() + "_VIEWMODEL";

        ViewModelHolder<BaseViewModel> retainedViewModel = (ViewModelHolder<BaseViewModel>) fragmentManager.findFragmentByTag(vmTag);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if retained
            return retainedViewModel.getViewmodel();
        } else {

            BaseViewModel baseViewModel = null;

            switch (fragmentType) {
                case MENU:
                    NewFormViewModel newFormViewModel = new NewFormViewModel(Injection.provideDncaRepository(context));
                    newFormViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = newFormViewModel;
                    break;

                case FORM_DETAILS:
                    FormDetailsViewModel formDetailsViewModel = new FormDetailsViewModel(Injection.provideDncaRepository(context));
//                    formDetailsViewModel.setViewComponent(this);
                    baseViewModel = formDetailsViewModel;
                    break;

                case GEN_INFO:
                    GeneralInformationViewModel generalInformationViewModel = new GeneralInformationViewModel(Injection.provideDncaRepository(context));
                    generalInformationViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = generalInformationViewModel;
                    break;

                case GEN_INFO_CALAMITY:
                    CalamityDetailsViewModel calamityDetailsViewModel = new CalamityDetailsViewModel(Injection.provideDncaRepository(context));
                    calamityDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = calamityDetailsViewModel;
                    break;

                case GEN_INFO_POPULATION:
                    PopulationDataViewModel populationDataViewModel = new PopulationDataViewModel(Injection.provideDncaRepository(context));
                    populationDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = populationDataViewModel;
                    break;

                case GEN_INFO_FAMILY:
                    FamilyDetailsViewModel familyDetailsViewModel = new FamilyDetailsViewModel(Injection.provideDncaRepository(context));
                    familyDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = familyDetailsViewModel;
                    break;

                case GEN_INFO_VULNERABLE:
                    VulnerableDataViewModel vulnerableDataViewModel = new VulnerableDataViewModel(Injection.provideDncaRepository(context));
                    vulnerableDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = vulnerableDataViewModel;
                    break;

                case GEN_INFO_CASUALTIES:
                    CasualtiesDataViewModel casualtiesDataViewModel = new CasualtiesDataViewModel(Injection.provideDncaRepository(context));
                    casualtiesDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = casualtiesDataViewModel;
                    break;

                case GEN_INFO_DEATH_CAUSE:
                    DeathCauseDataViewModel deathCauseDataViewModel = new DeathCauseDataViewModel(Injection.provideDncaRepository(context));
                    deathCauseDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = deathCauseDataViewModel;
                    break;

                case GEN_INFO_INFRASTRUCTURE:
                    InfrastructureDataViewModel infrastructureDataViewModel = new InfrastructureDataViewModel(Injection.provideDncaRepository(context));
                    infrastructureDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = infrastructureDataViewModel;
                    break;

                case SHELTER_INFO:
                    ShelterInformationViewModel shelterInformationViewModel = new ShelterInformationViewModel(Injection.provideDncaRepository(context));
                    shelterInformationViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = shelterInformationViewModel;
                    break;

                case SHELTER_INFO_DAMAGE:
                    DamageDataViewModel damageDataViewModel = new DamageDataViewModel(Injection.provideDncaRepository(context));
                    damageDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = damageDataViewModel;
                    break;
                    
                case SHELTER_INFO_COPING:
                    ShelterCopingDetailsViewModel shelterCopingDetailsViewModel = new ShelterCopingDetailsViewModel(Injection.provideDncaRepository(context));
//                    shelterCopingDetailsViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = shelterCopingDetailsViewModel;
                    break;

                case SHELTER_INFO_NEEDS:
                    ShelterNeedsDataViewModel shelterNeedsDataViewModel = new ShelterNeedsDataViewModel(Injection.provideDncaRepository(context));
                    shelterNeedsDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = shelterNeedsDataViewModel;
                    break;

                case SHELTER_ASSISTANCE:
                    ShelterAssistanceDataViewModel shelterAssistanceDataViewModel = new ShelterAssistanceDataViewModel(Injection.provideDncaRepository(context));
                    shelterAssistanceDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = shelterAssistanceDataViewModel;
                    break;


                case SHELTER_INFO_GAPS:
                    ShelterGapsDetailsViewModel shelterGapsDetailsViewModel = new ShelterGapsDetailsViewModel(Injection.provideDncaRepository(context));
//                    shelterGapsDetailsViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = shelterGapsDetailsViewModel;
                    break;

                case FOOD_SECURITY:
                    FoodSecurityInformationViewModel foodSecurityInformationViewModel = new FoodSecurityInformationViewModel(Injection.provideDncaRepository(context));
                    foodSecurityInformationViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = foodSecurityInformationViewModel;
                    break;

                case FOOD_SECURITY_IMPACT:
                    ImpactDetailsViewModel impactDetailsViewModel = new ImpactDetailsViewModel(Injection.provideDncaRepository(context));
//                    impactDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = impactDetailsViewModel;
                    break;

                case FOOD_SECURITY_COPING:
                    FoodSecurityCopingDetailsViewModel foodSecurityCopingDetailsViewModel = new FoodSecurityCopingDetailsViewModel(Injection.provideDncaRepository(context));
//                    foodSecurityCopingDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = foodSecurityCopingDetailsViewModel;
                    break;

                case FOOD_SECURITY_NEEDS:
                    FoodSecurityNeedsDetailsViewModel foodSecurityNeedsDetailsViewModel = new FoodSecurityNeedsDetailsViewModel(Injection.provideDncaRepository(context));
//                    foodSecurityNeedsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = foodSecurityNeedsDetailsViewModel;
                    break;
                    
                case FOOD_SECURITY_ASSISTANCE:
                    FoodSecurityAssistanceDataViewModel foodSecurityAssistanceDataViewModel = new FoodSecurityAssistanceDataViewModel(Injection.provideDncaRepository(context));
                    foodSecurityAssistanceDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = foodSecurityAssistanceDataViewModel;
                    break;

                case FOOD_SECURITY_GAPS:
                    FoodSecurityGapsDetailsViewModel foodSecurityGapsDetailsViewModel = new FoodSecurityGapsDetailsViewModel(Injection.provideDncaRepository(context));
//                    foodSecurityGapsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = foodSecurityGapsDetailsViewModel;
                    break;

                case LIVELIHOODS:
                    LivelihoodsInformationViewModel livelihoodsInformationViewModel = new LivelihoodsInformationViewModel(Injection.provideDncaRepository(context));
                    livelihoodsInformationViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = livelihoodsInformationViewModel;
                    break;

                case LIVELIHOODS_BEFORE:
                    IncomeSourceDataBeforeViewModel incomeSourceDataBeforeViewModel = new IncomeSourceDataBeforeViewModel(Injection.provideDncaRepository(context));
                    incomeSourceDataBeforeViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = incomeSourceDataBeforeViewModel;
                    break;

                case LIVELIHOODS_AFTER:
                    IncomeSourceDataAfterViewModel incomeSourceDataAfterViewModel = new IncomeSourceDataAfterViewModel(Injection.provideDncaRepository(context));
                    incomeSourceDataAfterViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = incomeSourceDataAfterViewModel;
                    break;

                case LIVELIHOODS_DAMAGE:
                    DamageCostDataViewModel damageCostDataViewModel = new DamageCostDataViewModel(Injection.provideDncaRepository(context));
                    damageCostDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = damageCostDataViewModel;
                    break;

                case LIVELIHOODS_COPING:
                    LivelihoodsCopingDetailsViewModel livelihoodsCopingDetailsViewModel = new LivelihoodsCopingDetailsViewModel(Injection.provideDncaRepository(context));
//                    livelihoodsCopingDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = livelihoodsCopingDetailsViewModel;
                    break;

                case LIVELIHOODS_NEEDS:
                    LivelihoodsNeedsDetailsViewModel livelihoodsNeedsDetailsViewModel = new LivelihoodsNeedsDetailsViewModel(Injection.provideDncaRepository(context));
//                    livelihoodsNeedsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = livelihoodsNeedsDetailsViewModel;
                    break;

                case LIVELIHOODS_ASSISTANCE:
                    LivelihoodsAssistanceDataViewModel livelihoodsAssistanceDataViewModel = new LivelihoodsAssistanceDataViewModel(Injection.provideDncaRepository(context));
                    livelihoodsAssistanceDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = livelihoodsAssistanceDataViewModel;
                    break;
                    
                case LIVELIHOODS_GAPS:
                    LivelihoodsGapsDetailsViewModel livelihoodsGapsDetailsViewModel = new LivelihoodsGapsDetailsViewModel(Injection.provideDncaRepository(context));
//                    livelihoodsGapsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = livelihoodsGapsDetailsViewModel;
                    break;

                case HEALTH:
                    HealthInformationViewModel healthInformationViewModel = new HealthInformationViewModel(Injection.provideDncaRepository(context));
                    healthInformationViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = healthInformationViewModel;
                    break;
                    
                case HEALTH_DISEASES:
                    DiseasesDataViewModel diseasesDataViewModel = new DiseasesDataViewModel(Injection.provideDncaRepository(context));
                    diseasesDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = diseasesDataViewModel;
                    break;

                case HEALTH_SPECIAL_NEEDS:
                    SpecialNeedsDataViewModel specialNeedsDataViewModel = new SpecialNeedsDataViewModel(Injection.provideDncaRepository(context));
                    specialNeedsDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = specialNeedsDataViewModel;
                    break;

                case HEALTH_PSYCHOSOCIAL:
                    PsychosocialDataViewModel psychosocialDataViewModel = new PsychosocialDataViewModel(Injection.provideDncaRepository(context));
                    psychosocialDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = psychosocialDataViewModel;
                    break;

                case HEALTH_COPING:
                    HealthCopingDetailsViewModel healthCopingDetailsViewModel = new HealthCopingDetailsViewModel(Injection.provideDncaRepository(context));
//                    healthCopingDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = healthCopingDetailsViewModel;
                    break;
                    
                case HEALTH_ASSISTANCE:
                    HealthAssistanceDataViewModel healthAssistanceDataViewModel = new HealthAssistanceDataViewModel(Injection.provideDncaRepository(context));
                    healthAssistanceDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = healthAssistanceDataViewModel;
                    break;

                case HEALTH_GAPS:
                    HealthGapsDetailsViewModel healthGapsDetailsViewModel = new HealthGapsDetailsViewModel(Injection.provideDncaRepository(context));
//                    healthGapsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = healthGapsDetailsViewModel;
                    break;
                    
                case WASH:
                    WashInformationViewModel washInformationViewModel = new WashInformationViewModel(Injection.provideDncaRepository(context));
                    washInformationViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = washInformationViewModel;
                    break;
                    
                case WASH_CONDITIONS:
                    WashConditionsDetailsViewModel washConditionsDetailsViewModel = new WashConditionsDetailsViewModel(Injection.provideDncaRepository(context));
//                    washConditionsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = washConditionsDetailsViewModel;
                    break;

                case WASH_COPING:
                    WashCopingDetailsViewModel washCopingDetailsViewModel = new WashCopingDetailsViewModel(Injection.provideDncaRepository(context));
//                    washCopingDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = washCopingDetailsViewModel;
                    break;
                    
                case WASH_ASSISTANCE:
                    WashAssistanceDataViewModel washAssistanceDataViewModel = new WashAssistanceDataViewModel(Injection.provideDncaRepository(context));
                    washAssistanceDataViewModel.setViewComponent((ITemplateEnumDataFragment) baseInterface);
                    baseViewModel = washAssistanceDataViewModel;
                    break;

                case WASH_GAPS:
                    WashGapsDetailsViewModel washGapsDetailsViewModel = new WashGapsDetailsViewModel(Injection.provideDncaRepository(context));
//                    washGapsDetailsViewModel.setViewComponent((INewFormActivity) baseInterface);
                    baseViewModel = washGapsDetailsViewModel;
                    break;
                    
            }

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    fragmentManager,
                    ViewModelHolder.createContainer(baseViewModel),
                    vmTag);

            return baseViewModel;
        }
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
//                    selectedFragment = ShelterGapsDetailsFragment.newInstance();
                    break;
                case GEN_INFO_POPULATION:
//                    selectedFragment = DeathCauseDataFragment.newInstance();
                    break;
                case GEN_INFO_FAMILY:
                    selectedFragment = FamilyDataFragment.newInstance();
                    break;
                case GEN_INFO_VULNERABLE:
                    selectedFragment = VulnerablePopulationFragment.newInstance();
                    break;
                case GEN_INFO_CASUALTIES:
//                    selectedFragment = CasualtiesDataFragment.newInstance();
                    break;
                case GEN_INFO_DEATH_CAUSE:
//                    selectedFragment = DeathCauseDataFragment.newInstance();
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    selectedFragment = InfrastructureDamageFragment.newInstance();
                    break;

                // Shelter and Non-Food Items
                case SHELTER_HOUSE_DAMAGE:
                    selectedFragment = HouseDamageFragment.newInstance();
                    break;
                case SHELTER_NEEDS:
//                    selectedFragment = ShelterNeedsFragment.newInstance();
                    break;
                case SHELTER_COPING:
                    selectedFragment = ShelterCopingDataFragment.newInstance();
                    break;
                case SHELTER_ASSISTANCE:
//                    selectedFragment = FoodSecurityAssistanceDataFragment.newInstance();
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
//                    selectedFragment = IncomeSourceDataAfterFragment.newInstance();
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
//                    selectedFragment = HealthAssistanceDataFragment.newInstance();
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
//                    selectedFragment = WashAssistanceDataFragment.newInstance();
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
     * Finds a viewModel and unbinds it if it exists
     * @param fragmentManager
     * @param fragmentType
     */
    public static void findAndUnbindViewModel(FragmentManager fragmentManager,
                                              NewDncaActivity.NewDncaComponent fragmentType) {

        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) fragmentManager.findFragmentByTag(tag);
        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            fragmentManager.beginTransaction().remove(retainedViewModel).commit();
        }
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
                    viewModel = new GenFormDetailsViewModel((IFormDetailsViewModel) repositoryManager);
                    break;
                case FORM_INTERVIEW_DETAILS:
                    viewModel = new InterviewDetailsViewModel((IFormDetailsViewModel) repositoryManager);
                    break;

                // General Information
                case GEN_INFO_CALAMITY:
//                    viewModel = new ShelterGapsDetailsViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_POPULATION:
//                    viewModel = new DeathCauseDataViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_FAMILY:
                    viewModel = new FamilyDataViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_VULNERABLE:
                    viewModel = new VulnerablePopulationViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_CASUALTIES:
//                    viewModel = new CasualtiesDataViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_DEATH_CAUSE:
//                    viewModel = new DeathCauseDataViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                case GEN_INFO_INFRASTRUCTURE:
                    viewModel = new InfrastructureDamageViewModel((GenInfoRepositoryManager)repositoryManager);
                    break;
                    
                // Shelter and Non-Food Items
                case SHELTER_HOUSE_DAMAGE:
                    viewModel = new HouseDamageViewModel((ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_NEEDS:
//                    viewModel = new ShelterNeedsViewModel((ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_COPING:
                    viewModel = new ShelterCopingDataViewModel((ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_ASSISTANCE:
//                    viewModel = new FoodSecurityAssistanceDataViewModel((ShelterInfoRepositoryManager)repositoryManager);
                    break;
                case SHELTER_GAPS:
                    viewModel = new ShelterGapsDataViewModel((ShelterInfoRepositoryManager)repositoryManager);
                    break;
                    
                // Food Security
                case FOOD_IMPACT:
                    viewModel = new FoodImpactDataViewModel((FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_COPING:
                    viewModel = new FoodCopingDataViewModel((FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_NEEDS:
                    viewModel = new FoodNeedsDataViewModel((FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_ASSISTANCE:
//                    viewModel = new FoodSecurityAssistanceDataViewModel((FoodSecurityRepositoryManager)repositoryManager);
                    break;
                case FOOD_GAPS:
                    viewModel = new FoodGapsDataViewModel((FoodSecurityRepositoryManager)repositoryManager);
                    break;
                    
                // Livelihoods
                case LIVELIHOODS_INCOME_BEFORE:
                    viewModel = new LivelihoodsIncomeViewModel((LivelihoodsRepositoryManager)repositoryManager, true);
                    break;
                case LIVELIHOODS_INCOME_AFTER:
                    viewModel = new LivelihoodsIncomeViewModel((LivelihoodsRepositoryManager)repositoryManager, false);
                    break;
                case LIVELIHOODS_DAMAGE:
                    viewModel = new LivelihoodsDamageViewModel((LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_COPING:
                    viewModel = new LivelihoodsCopingDataViewModel((LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_NEEDS:
                    viewModel = new LivelihoodsNeedsDataViewModel((LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_ASSISTANCE:
//                    viewModel = new FoodSecurityAssistanceDataViewModel((LivelihoodsRepositoryManager)repositoryManager);
                    break;
                case LIVELIHOODS_GAPS:
                    viewModel = new LivelihoodsGapsDataViewModel((LivelihoodsRepositoryManager)repositoryManager);
                    break;

                // Health
                case HEALTH_DISEASES:
                    viewModel = new DiseasesInjuriesViewModel((HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_SPECIAL_NEEDS:
                    viewModel = new SpecialNeedsViewModel((HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_PSYCHOSOCIAL:
                    viewModel = new PsychosocialViewModel((HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_COPING:
                    viewModel = new HealthCopingDataViewModel((HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_ASSISTANCE:
//                    viewModel = new FoodSecurityAssistanceDataViewModel((HealthRepositoryManager)repositoryManager);
                    break;
                case HEALTH_GAPS:
                    viewModel = new HealthGapsDataViewModel((HealthRepositoryManager)repositoryManager);
                    break;
                    
                // Water, Sanitation, and Hygiene
                case WASH_CONDITIONS:
                    viewModel = new WashConditionsViewModel((WashRepositoryManager)repositoryManager);
                    break;
                case WASH_COPING:
                    viewModel = new WashCopingDataViewModel((WashRepositoryManager)repositoryManager);
                    break;
                case WASH_ASSISTANCE:
//                    viewModel = new FoodSecurityAssistanceDataViewModel((WashRepositoryManager)repositoryManager);
                    break;
                case WASH_GAPS:
                    viewModel = new WashGapsDataViewModel((WashRepositoryManager)repositoryManager);
                    break;

                // Evacuation Centers
                case EVACUATION_SITE:
                    viewModel = new EvacuationSiteDataViewModel((EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_POPULATION:
                    viewModel = new EvacuationPopulationViewModel((EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_FACILITIES:
                    viewModel = new EvacuationFacilitiesDataViewModel((EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_WASH:
                    viewModel = new EvacuationWashDataViewModel((EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_SECURITY:
                    viewModel = new EvacuationSecurityDataViewModel((EvacuationItemRepositoryManager)repositoryManager);
                    break;
                case EVACUATION_COPING:
                    viewModel = new EvacuationCopingDataViewModel((EvacuationItemRepositoryManager)repositoryManager);
                    break;
            }

            ActivityUtils.bindViewModel(fragmentManager, retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

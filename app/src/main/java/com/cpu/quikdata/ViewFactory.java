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
import com.cpu.quikdata.Modules.NewDnca.Base.RepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationCopingData.EvacuationCopingDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationFacilitiesData.EvacuationFacilitiesDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.EvacuationPopulationFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSecurityData.EvacuationSecurityDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationSiteData.EvacuationSiteDataFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationWashData.EvacuationWashDataFragment;
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
                                                              RepositoryManager repositoryManager,
                                                              Context context) {

        NewDncaBaseViewModel viewModel = null;
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) fragmentManager.findFragmentByTag(tag);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {

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
            }

            ActivityUtils.bindViewModel(fragmentManager, retainedViewModel, viewModel, tag);
        }
        return viewModel;
    }
}

package com.cpu.quikdata.ModulesV2.NewForm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.BaseActivity;
import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationInfoListFragment;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationInfoListViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.GeneralInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.GeneralInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterInformationViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashInformationViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.ViewFactory;

public class NewFormActivity extends BaseActivity implements INewFormActivity {

    public enum NewFormComponent {
        MENU,
        FORM_DETAILS,

        GEN_INFO,
        GEN_INFO_CALAMITY,
        GEN_INFO_POPULATION,
        GEN_INFO_FAMILY,
        GEN_INFO_VULNERABLE,
        GEN_INFO_CASUALTIES,
        GEN_INFO_DEATH_CAUSE,
        GEN_INFO_INFRASTRUCTURE,

        SHELTER_INFO,
        SHELTER_INFO_DAMAGE,
        SHELTER_INFO_COPING,
        SHELTER_INFO_NEEDS,
        SHELTER_ASSISTANCE,
        SHELTER_INFO_GAPS,

        FOOD_SECURITY,
        FOOD_SECURITY_IMPACT,
        FOOD_SECURITY_COPING,
        FOOD_SECURITY_NEEDS,
        FOOD_SECURITY_ASSISTANCE,
        FOOD_SECURITY_GAPS,

        LIVELIHOODS,
        LIVELIHOODS_BEFORE,
        LIVELIHOODS_AFTER,
        LIVELIHOODS_DAMAGE,
        LIVELIHOODS_COPING,
        LIVELIHOODS_NEEDS,
        LIVELIHOODS_ASSISTANCE,
        LIVELIHOODS_GAPS,

        HEALTH,
        HEALTH_DISEASES,
        HEALTH_SPECIAL_NEEDS,
        HEALTH_PSYCHOSOCIAL,
        HEALTH_COPING,
        HEALTH_ASSISTANCE,
        HEALTH_GAPS,

        WASH,
        WASH_CONDITIONS,
        WASH_COPING,
        WASH_ASSISTANCE,
        WASH_GAPS,

        EVACUATION,
        EVACUATION_ITEM,
        EVACUATION_ITEM_CENTER,
        EVACUATION_ITEM_POPULATION,
        EVACUATION_ITEM_WASH,
        EVACUATION_ITEM_FACILITIES,
        EVACUATION_ITEM_PROTECTION,
        EVACUATION_ITEM_COPING,
        
        CASE_STORIES
    }

    private static int FRAGMENT_CONTAINER = R.id.new_form_fragment_container;
    private static final String TOOLBAR_TITLE = "New DNCA Form";
    private NewFormViewModel mNewFormViewModel;
    private boolean mIsEditMode = false;

    public NewFormActivity() {
        super(TOOLBAR_TITLE, FRAGMENT_CONTAINER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        // Get item ID from bundle extra
        String itemId = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mIsEditMode = true;
            itemId = extras.getString(AppConstants.FORM_ITEM_ID);
        }

        // Setup the toolbar
        setupToolbar(true);

        NewFormFragment newFormFragment = (NewFormFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.MENU, FRAGMENT_CONTAINER);
        mNewFormViewModel = (NewFormViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.MENU, this, this);
        newFormFragment.setViewModel(mNewFormViewModel);

        mNewFormViewModel.getData(itemId);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            mNewFormViewModel.navigateOnBackButtonPressed();
        }
        super.onBackPressed();
    }

    @Override
    public void onFormDetailsButtonPressed() {
        FormDetailsFragment formDetailsFragment = (FormDetailsFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.FORM_DETAILS, FRAGMENT_CONTAINER);
        final FormDetailsViewModel formDetailsViewModel = (FormDetailsViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.FORM_DETAILS, this, this);
        formDetailsFragment.setViewModel(formDetailsViewModel);
    }

    @Override
    public void onGenInfoButtonPressed() {
        GeneralInformationFragment generalInformationFragment = (GeneralInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.GEN_INFO, FRAGMENT_CONTAINER);
        final GeneralInformationViewModel generalInformationViewModel = (GeneralInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.GEN_INFO, this, this);
        generalInformationFragment.setViewModel(generalInformationViewModel);
    }

    @Override
    public void onShelterInfoButtonPressed() {
        ShelterInformationFragment shelterInformationFragment = (ShelterInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.SHELTER_INFO, FRAGMENT_CONTAINER);
        final ShelterInformationViewModel shelterInformationViewModel = (ShelterInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.SHELTER_INFO, this, this);
        shelterInformationFragment.setViewModel(shelterInformationViewModel);
    }

    @Override
    public void onFoodSecurityInfoButtonPressed() {
        FoodSecurityInformationFragment foodSecurityInformationFragment = (FoodSecurityInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.FOOD_SECURITY, FRAGMENT_CONTAINER);
        final FoodSecurityInformationViewModel foodSecurityInformationViewModel = (FoodSecurityInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.FOOD_SECURITY, this, this);
        foodSecurityInformationFragment.setViewModel(foodSecurityInformationViewModel);
    }

    @Override
    public void onLivelihoodsInfoButtonPressed() {
        LivelihoodsInformationFragment livelihoodsInformationFragment = (LivelihoodsInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.LIVELIHOODS, FRAGMENT_CONTAINER);
        final LivelihoodsInformationViewModel livelihoodsInformationViewModel = (LivelihoodsInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.LIVELIHOODS, this, this);
        livelihoodsInformationFragment.setViewModel(livelihoodsInformationViewModel);        
    }

    @Override
    public void onHealthInfoButtonPressed() {
        HealthInformationFragment healthInformationFragment = (HealthInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.HEALTH, FRAGMENT_CONTAINER);
        final HealthInformationViewModel healthInformationViewModel = (HealthInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.HEALTH, this, this);
        healthInformationFragment.setViewModel(healthInformationViewModel);
    }

    @Override
    public void onWashInfoButtonPressed() {
        WashInformationFragment washInformationFragment = (WashInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.WASH, FRAGMENT_CONTAINER);
        final WashInformationViewModel washInformationViewModel = (WashInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.WASH, this, this);
        washInformationFragment.setViewModel(washInformationViewModel);
    }

    @Override
    public void onEvacuationInfoButtonPressed() {
        EvacuationInfoListFragment evacuationInfoListFragment = (EvacuationInfoListFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.EVACUATION, FRAGMENT_CONTAINER);
        final EvacuationInfoListViewModel evacuationInfoListViewModel = (EvacuationInfoListViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.EVACUATION, this, this);
        evacuationInfoListViewModel.setViewComponent(evacuationInfoListFragment);
        evacuationInfoListFragment.setViewModel(evacuationInfoListViewModel);
    }

    @Override
    public void onCaseStoriesButtonPressed() {

    }

    @Override
    public void onSaveButtonPressed() {
        super.onBackPressed();
    }
}

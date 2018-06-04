package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FormDetails.NewDncaFormDetailsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FormDetails.NewDncaFormDetailsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.HealthViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterInfoFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterInfoViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;
import com.rjdeleon.mvp_app.databinding.NewDncaActivityBinding;

import java.util.List;

public class NewDncaActivity extends AppCompatActivity implements NewDncaNavigator {

    public static final String NEW_DNCA_VIEWMODEL_TAG = "NEW_DNCA_VIEWMODEL_TAG";
    public static final String NEW_DNCA_FORM_DETAILS_VIEWMODEL_TAG = "NEW_DNCA_FORM_DETAILS_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_VIEWMODEL_TAG";
    public static final String SHELTER_INFO_VIEWMODEL_TAG = "SHELTER_INFO_VIEWMODEL_TAG";
    public static final String FOOD_SECURITY_VIEWMODEL_TAG = "FOOD_SECURITY_VIEWMODEL_TAG";
    public static final String LIVELIHOODS_VIEWMODEL_TAG = "LIVELIHOODS_VIEWMODEL_TAG";
    public static final String HEALTH_VIEWMODEL_TAG = "HEALTH_VIEWMODEL_TAG";
    public static final String WASH_VIEWMODEL_TAG = "WASH_VIEWMODEL_TAG";
    public static final String EVACUATION_VIEWMODEL_TAG = "EVACUATION_VIEWMODEL_TAG";

    private NewDncaViewModel mMainViewModel;
    private NewDncaFormDetailsViewModel mFormDetailsViewModel;
    private GenInfoViewModel mGenInfoViewModel;
    private ShelterInfoViewModel mShelterInfoViewModel;
    private FoodSecurityViewModel mFoodSecurityViewModel;
    private LivelihoodsViewModel mLivelihoodsViewModel;
    private HealthViewModel mHealthViewModel;
    private WashViewModel mWashViewModel;
    private EvacuationViewModel mEvacuationViewModel;

    private NewDncaActivityBinding mMainBinding;

    private enum NewDncaComponent {
        MENU,
        FORM_DETAILS,
        GEN_INFO,
        SHELTER_INFO,
        FOOD_SECURITY,
        LIVELIHOODS,
        HEALTH,
        WASH,
        EVACUATION,
        CASE_STORIES
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.new_dnca_activity);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar_new_dnca);
        setSupportActionBar(toolbar);

        // Setup view and viewModel
        NewDncaFragment newDncaFragment = (NewDncaFragment) findOrCreateViewFragment(NewDncaComponent.MENU);
        mMainViewModel = (NewDncaViewModel) findOrCreateViewModel(NewDncaComponent.MENU);

        // Link view and viewModel
        newDncaFragment.setViewModel(mMainViewModel);
        mMainViewModel.setNewDncaNavigator(this);

        // Bind viewModel to view
        mMainBinding.setViewModel(mMainViewModel);

        Fragment topFragment = getSupportFragmentManager().findFragmentById(R.id.new_dnca_fragment_container);
        if (topFragment == null) return;
        if(topFragment instanceof NewDncaFormDetailsFragment) {
            ((NewDncaFormDetailsFragment) topFragment).setViewModel((NewDncaFormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS));
        }
        if(topFragment instanceof GenInfoFragment) {
            ((GenInfoFragment) topFragment).setViewModel((GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO));
        }
    }

    @Override
    protected void onStop() {
        mMainViewModel.performCleanup();
        super.onStop();
    }

    @Override
    public void onBackButtonPressed() {
        onBackPressed();
    }

    /**
     * Show form details fragment
     */
    @Override
    public void onFormDetailsButtonPressed() {
        NewDncaFormDetailsFragment newDncaFormDetailsFragment = (NewDncaFormDetailsFragment) findOrCreateViewFragment(NewDncaComponent.FORM_DETAILS);
        mFormDetailsViewModel = (NewDncaFormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS);
        newDncaFormDetailsFragment.setViewModel(mFormDetailsViewModel);
    }

    /**
     * Show general information fragment
     */
    @Override
    public void onGenInfoButtonPressed() {
        GenInfoFragment genInfoFragment = (GenInfoFragment) findOrCreateViewFragment(NewDncaComponent.GEN_INFO);
        mGenInfoViewModel = (GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
        genInfoFragment.setViewModel(mGenInfoViewModel);
    }

    /**
     * Show shelter information fragment
     */
    @Override
    public void onShelterInfoButtonPressed() {
        ShelterInfoFragment shelterInfoFragment = (ShelterInfoFragment) findOrCreateViewFragment(NewDncaComponent.SHELTER_INFO);
        mShelterInfoViewModel = (ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO);
        shelterInfoFragment.setViewModel(mShelterInfoViewModel);
    }

    /**
     * Show food security fragment
     */
    @Override
    public void onFoodSecurityButtonPressed() {
        FoodSecurityFragment foodSecurityFragment = (FoodSecurityFragment) findOrCreateViewFragment(NewDncaComponent.FOOD_SECURITY);
        mFoodSecurityViewModel = (FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY);
        foodSecurityFragment.setViewModel(mFoodSecurityViewModel);
    }

    /**
     * Show livelihoods fragment
     */
    @Override
    public void onLivelihoodsButtonPressed() {
        LivelihoodsFragment livelihoodsFragment = (LivelihoodsFragment) findOrCreateViewFragment(NewDncaComponent.LIVELIHOODS);
        mLivelihoodsViewModel = (LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS);
        livelihoodsFragment.setViewModel(mLivelihoodsViewModel);
    }

    /**
     * Show health fragment
     */
    @Override
    public void onHealthButtonPressed() {
        HealthFragment healthFragment = (HealthFragment) findOrCreateViewFragment(NewDncaComponent.HEALTH);
        mHealthViewModel = (HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH);
        healthFragment.setViewModel(mHealthViewModel);
    }

    /**
     * Show wash fragment
     */
    @Override
    public void onWashButtonPressed() {
        WashFragment washFragment = (WashFragment) findOrCreateViewFragment(NewDncaComponent.WASH);
        mWashViewModel = (WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH);
        washFragment.setViewModel(mWashViewModel);
    }

    /**
     * Show evacuation fragment
     */
    @Override
    public void onEvacuationButtonPressed() {
        EvacuationFragment evacuationFragment = (EvacuationFragment) findOrCreateViewFragment(NewDncaComponent.EVACUATION);
        mEvacuationViewModel = (EvacuationViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION);
        evacuationFragment.setViewModel(mEvacuationViewModel);
    }

    @NonNull
    private Fragment findOrCreateViewFragment(NewDncaComponent fragmentType) {

        // Retrieve fragment if it exists
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.new_dnca_fragment_container);
        boolean addToBackstack = true;

        switch(fragmentType) {
            case MENU:
                if (fragment == null || !(fragment instanceof NewDncaFragment)) {
                    fragment = NewDncaFragment.newInstance();
                    addToBackstack = false;
                }
                break;

            case FORM_DETAILS:
                if (fragment == null || !(fragment instanceof NewDncaFormDetailsFragment)) {
                    fragment = NewDncaFormDetailsFragment.newInstance();
                }
                break;

            case GEN_INFO:
                if (fragment == null || !(fragment instanceof GenInfoFragment)) {
                    fragment = GenInfoFragment.newInstance();
                }
                break;

            case SHELTER_INFO:
                if (fragment == null || !(fragment instanceof ShelterInfoFragment)) {
                    fragment = ShelterInfoFragment.newInstance();
                }
                break;

            case FOOD_SECURITY:
                if (fragment == null || !(fragment instanceof FoodSecurityFragment)) {
                    fragment = FoodSecurityFragment.newInstance();
                }
                break;

            case LIVELIHOODS:
                if (fragment == null || !(fragment instanceof LivelihoodsFragment)) {
                    fragment = LivelihoodsFragment.newInstance();
                }
                break;

            case HEALTH:
                if (fragment == null || !(fragment instanceof HealthFragment)) {
                    fragment = HealthFragment.newInstance();
                }
                break;

            case WASH:
                if (fragment == null || !(fragment instanceof WashFragment)) {
                    fragment = WashFragment.newInstance();
                }
                break;

            case EVACUATION:
                if (fragment == null || !(fragment instanceof EvacuationFragment)) {
                    fragment = EvacuationFragment.newInstance();
                }
                break;
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.new_dnca_fragment_container, addToBackstack);
        return fragment;
    }

    @NonNull
    private com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel findOrCreateViewModel(NewDncaComponent fragmentType) {

        com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel viewModel = null;
        String tag = null;

        switch(fragmentType) {
            case MENU:
                // TODO: Restore view model for config change
                // Create viewModel
                viewModel = new NewDncaViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = NEW_DNCA_VIEWMODEL_TAG;
                break;

            case FORM_DETAILS:
                viewModel = new NewDncaFormDetailsViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = NEW_DNCA_FORM_DETAILS_VIEWMODEL_TAG;
                break;

            case GEN_INFO:
                viewModel = new GenInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = NEW_DNCA_GEN_INFO_VIEWMODEL_TAG;
                break;

            case SHELTER_INFO:
                viewModel = new ShelterInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = SHELTER_INFO_VIEWMODEL_TAG;
                break;

            case FOOD_SECURITY:
                viewModel = new FoodSecurityViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = FOOD_SECURITY_VIEWMODEL_TAG;
                break;

            case LIVELIHOODS:
                viewModel = new LivelihoodsViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = LIVELIHOODS_VIEWMODEL_TAG;
                break;

            case HEALTH:
                viewModel = new HealthViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = HEALTH_VIEWMODEL_TAG;
                break;

            case WASH:
                viewModel = new WashViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = WASH_VIEWMODEL_TAG;
                break;

            case EVACUATION:
                viewModel = new EvacuationViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = EVACUATION_VIEWMODEL_TAG;
                break;
        }

        // Bind viewModel to activity's lifecycle using fragment manager
        ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(),
                ViewModelHolder.createContainer(viewModel),
                tag);

        return viewModel;
    }
}

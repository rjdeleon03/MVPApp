package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
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

    private NewDncaFragment mNewDncaFragment;
    private NewDncaFormDetailsFragment mFormDetailsFragment;
    private GenInfoFragment mGenInfoFragment;
    private ShelterInfoFragment mShelterInfoFragment;
    private FoodSecurityFragment mFoodSecurityFragment;
    private LivelihoodsFragment mLivelihoodsFragment;
    private HealthFragment mHealthFragment;
    private WashFragment mWashFragment;
    private EvacuationFragment mEvacuationFragment;

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

        {
            // Setup view and viewModel
            mNewDncaFragment = (NewDncaFragment) findOrCreateViewFragment(NewDncaComponent.MENU);
            mMainViewModel = (NewDncaViewModel) findOrCreateViewModel(NewDncaComponent.MENU);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mNewDncaFragment, R.id.new_dnca_fragment_container, false);

            // Link view and viewModel
            mNewDncaFragment.setViewModel(mMainViewModel);
            mMainViewModel.setNewDncaNavigator(this);

            // Bind viewModel to view
            mMainBinding.setViewModel(mMainViewModel);
        }

        {
            mFormDetailsFragment = (NewDncaFormDetailsFragment) findOrCreateViewFragment(NewDncaComponent.FORM_DETAILS);
            mFormDetailsViewModel = (NewDncaFormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS);
            mFormDetailsFragment.setViewModel(mFormDetailsViewModel);
        }

        {
            mGenInfoFragment = (GenInfoFragment) findOrCreateViewFragment(NewDncaComponent.GEN_INFO);
            mGenInfoViewModel = (GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
            mGenInfoFragment.setViewModel(mGenInfoViewModel);
        }

        {
            mShelterInfoFragment = (ShelterInfoFragment) findOrCreateViewFragment(NewDncaComponent.SHELTER_INFO);
            mShelterInfoViewModel = (ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO);
            mShelterInfoFragment.setViewModel(mShelterInfoViewModel);
        }

        {
            mFoodSecurityFragment = (FoodSecurityFragment) findOrCreateViewFragment(NewDncaComponent.FOOD_SECURITY);
            mFoodSecurityViewModel = (FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY);
            mFoodSecurityFragment.setViewModel(mFoodSecurityViewModel);
        }

        {
            mLivelihoodsFragment = (LivelihoodsFragment) findOrCreateViewFragment(NewDncaComponent.LIVELIHOODS);
            mLivelihoodsViewModel = (LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS);
            mLivelihoodsFragment.setViewModel(mLivelihoodsViewModel);
        }

        {
            mHealthFragment = (HealthFragment) findOrCreateViewFragment(NewDncaComponent.HEALTH);
            mHealthViewModel = (HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH);
            mHealthFragment.setViewModel(mHealthViewModel);
        }

        {
            mWashFragment = (WashFragment) findOrCreateViewFragment(NewDncaComponent.WASH);
            mWashViewModel = (WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH);
            mWashFragment.setViewModel(mWashViewModel);
        }

        {
            mEvacuationFragment = (EvacuationFragment) findOrCreateViewFragment(NewDncaComponent.EVACUATION);
            mEvacuationViewModel = (EvacuationViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION);
            mEvacuationFragment.setViewModel(mEvacuationViewModel);
        }
    }

    @NonNull
    private Fragment findOrCreateViewFragment2(NewDncaComponent fragmentType) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Fragment selectedFragment = null;
        for(Fragment fragment : fragments) {
            if(fragment instanceof NewDncaFragment && fragmentType == NewDncaComponent.MENU ||
                    fragment instanceof NewDncaFormDetailsFragment && fragmentType == NewDncaComponent.FORM_DETAILS ||
                    fragment instanceof GenInfoFragment && fragmentType == NewDncaComponent.GEN_INFO ||
                    fragment instanceof ShelterInfoFragment && fragmentType == NewDncaComponent.SHELTER_INFO ||
                    fragment instanceof FoodSecurityFragment && fragmentType == NewDncaComponent.FOOD_SECURITY ||
                    fragment instanceof LivelihoodsFragment && fragmentType == NewDncaComponent.LIVELIHOODS ||
                    fragment instanceof HealthFragment && fragmentType == NewDncaComponent.HEALTH ||
                    fragment instanceof WashFragment && fragmentType == NewDncaComponent.WASH ||
                    fragment instanceof EvacuationFragment && fragmentType == NewDncaComponent.EVACUATION) {
                selectedFragment = fragment;
                break;
            }
        }
        if (selectedFragment == null) {
            switch(fragmentType) {
                case MENU:
                    return NewDncaFragment.newInstance();
                case FORM_DETAILS:
                    return NewDncaFormDetailsFragment.newInstance();
                case SHELTER_INFO:
                    return ShelterInfoFragment.newInstance();
                case FOOD_SECURITY:
                    return FoodSecurityFragment.newInstance();
                case LIVELIHOODS:
                    return LivelihoodsFragment.newInstance();
                case HEALTH:
                    return HealthFragment.newInstance();
                case WASH:
                    return WashFragment.newInstance();
                case EVACUATION:
                    return EvacuationFragment.newInstance();
            }
        }
        return selectedFragment;
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
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFormDetailsFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show general information fragment
     */
    @Override
    public void onGenInfoButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mGenInfoFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show shelter information fragment
     */
    @Override
    public void onShelterInfoButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mShelterInfoFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show food security fragment
     */
    @Override
    public void onFoodSecurityButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFoodSecurityFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show livelihoods fragment
     */
    @Override
    public void onLivelihoodsButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mLivelihoodsFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show health fragment
     */
    @Override
    public void onHealthButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mHealthFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show wash fragment
     */
    @Override
    public void onWashButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mWashFragment, R.id.new_dnca_fragment_container, true);
    }

    /**
     * Show evacuation fragment
     */
    @Override
    public void onEvacuationButtonPressed() {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mEvacuationFragment, R.id.new_dnca_fragment_container, true);
    }

    @NonNull
    private Fragment findOrCreateViewFragment(NewDncaComponent fragmentType) {

        // Retrieve fragment if it exists
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.new_dnca_fragment_container);

        switch(fragmentType) {
            case MENU:
                if (fragment == null || !(fragment instanceof NewDncaFragment)) {
                    fragment = NewDncaFragment.newInstance();
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

        return fragment;
    }

    @NonNull
    private NewDncaBaseViewModel findOrCreateViewModel(NewDncaComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
        String tag = null;
        boolean isNewViewModel = false;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel = null;

        /*
        // Get viewModel
        ViewModelHolder<DNCAListViewModel> retainedViewModel = (ViewModelHolder<DNCAListViewModel>) getSupportFragmentManager().findFragmentByTag(DNCA_LIST_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if it was retained
            return retainedViewModel.getViewmodel();

        } else {

            // Create viewModel if it does not exist yet
            DNCAListViewModel dncaListViewModel = new DNCAListViewModel(
                    getApplicationContext(),
                    Injection.provideDncaRepository(getApplicationContext()));

            // Bind viewModel to activity's lifecycle using fragment manager
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(dncaListViewModel),
                    DNCA_LIST_VIEWMODEL_TAG);

            return dncaListViewModel;
        }
         */

        switch(fragmentType) {
            case MENU:
                tag = NEW_DNCA_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getSupportFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
                    viewModel = retainedViewModel.getViewmodel();
                } else {
                    viewModel = new NewDncaViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                }
                break;

            case FORM_DETAILS:
                tag = NEW_DNCA_FORM_DETAILS_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getSupportFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
                    viewModel = retainedViewModel.getViewmodel();
                } else {
                    viewModel = new NewDncaFormDetailsViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                }
                break;

            case GEN_INFO:
                tag = NEW_DNCA_GEN_INFO_VIEWMODEL_TAG;
                retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getSupportFragmentManager().findFragmentByTag(tag);
                if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
                    viewModel = retainedViewModel.getViewmodel();
                } else {
                    viewModel = new GenInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                }
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

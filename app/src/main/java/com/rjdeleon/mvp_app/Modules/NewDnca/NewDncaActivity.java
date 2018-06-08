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

import static com.rjdeleon.mvp_app.AppConstants.VIEWMODEL_TAG;

public class NewDncaActivity extends AppCompatActivity implements NewDncaNavigator {

    private NewDncaFragment mNewDncaFragment;
    private NewDncaViewModel mMainViewModel;

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

            // Link view and viewModel
            mNewDncaFragment.setViewModel(mMainViewModel);
            mMainViewModel.setNewDncaNavigator(this);

            // Bind viewModel to view
            mMainBinding.setViewModel(mMainViewModel);
        }

        // Restore viewModels if applicable when activity is started
        List<Fragment> loadedFragments = getSupportFragmentManager().getFragments();
        for(Fragment currentFragment : loadedFragments) {
            
            if (currentFragment instanceof ViewModelHolder) continue;

            if(currentFragment.getTag().equals(NewDncaComponent.FORM_DETAILS.toString())) {
                ((NewDncaFormDetailsFragment) currentFragment).setViewModel((NewDncaFormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS));

            } else if(currentFragment.getTag().equals(NewDncaComponent.GEN_INFO.toString())) {
                ((GenInfoFragment) currentFragment).setViewModel((GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO));

            } else if(currentFragment.getTag().equals(NewDncaComponent.SHELTER_INFO.toString())) {
                ((ShelterInfoFragment) currentFragment).setViewModel((ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO));

            } else if(currentFragment.getTag().equals(NewDncaComponent.FOOD_SECURITY.toString())) {
                ((FoodSecurityFragment) currentFragment).setViewModel((FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY));

            } else if(currentFragment.getTag().equals(NewDncaComponent.LIVELIHOODS.toString())) {
                ((LivelihoodsFragment) currentFragment).setViewModel((LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS));

            } else if(currentFragment.getTag().equals(NewDncaComponent.HEALTH.toString())) {
                ((HealthFragment) currentFragment).setViewModel((HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH));

            } else if(currentFragment.getTag().equals(NewDncaComponent.WASH.toString())) {
                ((WashFragment) currentFragment).setViewModel((WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH));

            } else if(currentFragment.getTag().equals(NewDncaComponent.EVACUATION.toString())) {
                ((EvacuationFragment) currentFragment).setViewModel((EvacuationViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION));

            }
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
        NewDncaFormDetailsFragment formDetailsFragment = (NewDncaFormDetailsFragment) findOrCreateViewFragment(NewDncaComponent.FORM_DETAILS);
        NewDncaFormDetailsViewModel formDetailsViewModel = (NewDncaFormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS);
        formDetailsFragment.setViewModel(formDetailsViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formDetailsFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.FORM_DETAILS.toString());
    }

    /**
     * Show general information fragment
     */
    @Override
    public void onGenInfoButtonPressed() {
        GenInfoFragment genInfoFragment = (GenInfoFragment) findOrCreateViewFragment(NewDncaComponent.GEN_INFO);
        GenInfoViewModel genInfoViewModel = (GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
        genInfoFragment.setViewModel(genInfoViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), genInfoFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.GEN_INFO.toString());
    }

    /**
     * Show shelter information fragment
     */
    @Override
    public void onShelterInfoButtonPressed() {
        ShelterInfoFragment shelterInfoFragment = (ShelterInfoFragment) findOrCreateViewFragment(NewDncaComponent.SHELTER_INFO);
        ShelterInfoViewModel shelterInfoViewModel = (ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO);
        shelterInfoFragment.setViewModel(shelterInfoViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), shelterInfoFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.SHELTER_INFO.toString());
    }

    /**
     * Show food security fragment
     */
    @Override
    public void onFoodSecurityButtonPressed() {
        FoodSecurityFragment foodSecurityFragment = (FoodSecurityFragment) findOrCreateViewFragment(NewDncaComponent.FOOD_SECURITY);
        FoodSecurityViewModel foodSecurityViewModel = (FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY);
        foodSecurityFragment.setViewModel(foodSecurityViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), foodSecurityFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.FOOD_SECURITY.toString());
    }

    /**
     * Show livelihoods fragment
     */
    @Override
    public void onLivelihoodsButtonPressed() {
        LivelihoodsFragment livelihoodsFragment = (LivelihoodsFragment) findOrCreateViewFragment(NewDncaComponent.LIVELIHOODS);
        LivelihoodsViewModel livelihoodsViewModel = (LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS);
        livelihoodsFragment.setViewModel(livelihoodsViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), livelihoodsFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.LIVELIHOODS.toString());
    }

    /**
     * Show health fragment
     */
    @Override
    public void onHealthButtonPressed() {
        HealthFragment healthFragment = (HealthFragment) findOrCreateViewFragment(NewDncaComponent.HEALTH);
        HealthViewModel healthViewModel = (HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH);
        healthFragment.setViewModel(healthViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), healthFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.HEALTH.toString());
    }

    /**
     * Show wash fragment
     */
    @Override
    public void onWashButtonPressed() {
        WashFragment washFragment = (WashFragment) findOrCreateViewFragment(NewDncaComponent.WASH);
        WashViewModel washViewModel = (WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH);
        washFragment.setViewModel(washViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), washFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.WASH.toString());
    }

    /**
     * Show evacuation fragment
     */
    @Override
    public void onEvacuationButtonPressed() {
        EvacuationFragment evacuationFragent = (EvacuationFragment) findOrCreateViewFragment(NewDncaComponent.EVACUATION);
        EvacuationViewModel evacuationViewModel = (EvacuationViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION);
        evacuationFragent.setViewModel(evacuationViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), evacuationFragent,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.EVACUATION.toString());
    }

    @NonNull
    private Fragment findOrCreateViewFragment(NewDncaComponent fragmentType) {

        // Retrieve fragment if it exists
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentType.toString());

        switch(fragmentType) {
            case MENU:
                if (fragment == null || !(fragment instanceof NewDncaFragment)) {
                    fragment = NewDncaFragment.newInstance();
                    ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                            fragment,
                            R.id.new_dnca_fragment_container,
                            false,
                            fragmentType.toString());
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
        String tag = fragmentType.toString() + VIEWMODEL_TAG;

        ViewModelHolder<NewDncaBaseViewModel> retainedViewModel;

        retainedViewModel = (ViewModelHolder<NewDncaBaseViewModel>) getSupportFragmentManager().findFragmentByTag(tag);
        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {
            viewModel = retainedViewModel.getViewmodel();
        } else {
            switch (fragmentType) {
                case MENU:
                    viewModel = new NewDncaViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case FORM_DETAILS:
                    viewModel = new NewDncaFormDetailsViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case GEN_INFO:
                    viewModel = new GenInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case SHELTER_INFO:
                    viewModel = new ShelterInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case FOOD_SECURITY:
                    viewModel = new FoodSecurityViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case LIVELIHOODS:
                    viewModel = new LivelihoodsViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case HEALTH:
                    viewModel = new HealthViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case WASH:
                    viewModel = new WashViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;

                case EVACUATION:
                    viewModel = new EvacuationViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                    viewModel.setNewDncaNavigator(this);
                    break;
            }

            if (retainedViewModel != null) {
                // If container already exists, just inject viewModel into container
                retainedViewModel.setViewModel(viewModel);

            } else {

                // Bind viewModel to activity's lifecycle using fragment manager
                ActivityUtils.addFragmentToActivity(
                        getSupportFragmentManager(),
                        ViewModelHolder.createContainer(viewModel),
                        tag);
            }
        }

        return viewModel;
    }
}

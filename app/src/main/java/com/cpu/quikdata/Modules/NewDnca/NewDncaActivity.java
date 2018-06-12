package com.cpu.quikdata.Modules.NewDnca;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesFragment;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesNavigator;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationFragment;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityFragment;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.NewDncaFormDetailsFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.NewDncaFormDetailsViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoFragment;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashFragment;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.Utils.ImageUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;
import com.cpu.quikdata.databinding.NewDncaActivityBinding;

import java.util.List;

import static com.cpu.quikdata.AppConstants.REQUEST_IMAGE_CAPTURE;
import static com.cpu.quikdata.AppConstants.VIEWMODEL_TAG;

public class NewDncaActivity extends AppCompatActivity implements NewDncaNavigator, CaseStoriesNavigator {

    private NewDncaFragment mNewDncaFragment;
    private NewDncaViewModel mMainViewModel;

    private NewDncaFormDetailsViewModel mFormDetailsViewModel;
    private GenInfoViewModel mGenInfoViewModel;
    private ShelterInfoViewModel mShelterInfoViewModel;
    private FoodSecurityViewModel mFoodSecurityViewModel;
    private LivelihoodsViewModel mLivelihoodsViewModel;
    private HealthViewModel mHealthViewModel;
    private WashViewModel mWashViewModel;
    private EvacuationViewModel mEvacuationViewModel;
    private CaseStoriesViewModel mCaseStoriesViewModel;

    private CameraOwner mCameraOwner = null;
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
        mFormDetailsViewModel = null;
        mGenInfoViewModel = null;
        mShelterInfoViewModel = null;
        mFoodSecurityViewModel = null;
        mLivelihoodsViewModel = null;
        mHealthViewModel = null;
        mWashViewModel = null;
        mEvacuationViewModel = null;
        mCaseStoriesViewModel = null;
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
        mFormDetailsViewModel = (NewDncaFormDetailsViewModel) findOrCreateViewModel(NewDncaComponent.FORM_DETAILS);
        formDetailsFragment.setViewModel(mFormDetailsViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formDetailsFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.FORM_DETAILS.toString());
    }

    /**
     * Show general information fragment
     */
    @Override
    public void onGenInfoButtonPressed() {
        GenInfoFragment genInfoFragment = (GenInfoFragment) findOrCreateViewFragment(NewDncaComponent.GEN_INFO);
        mGenInfoViewModel = (GenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
        genInfoFragment.setViewModel(mGenInfoViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), genInfoFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.GEN_INFO.toString());
    }

    /**
     * Show shelter information fragment
     */
    @Override
    public void onShelterInfoButtonPressed() {
        ShelterInfoFragment shelterInfoFragment = (ShelterInfoFragment) findOrCreateViewFragment(NewDncaComponent.SHELTER_INFO);
        mShelterInfoViewModel = (ShelterInfoViewModel) findOrCreateViewModel(NewDncaComponent.SHELTER_INFO);
        shelterInfoFragment.setViewModel(mShelterInfoViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), shelterInfoFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.SHELTER_INFO.toString());
    }

    /**
     * Show food security fragment
     */
    @Override
    public void onFoodSecurityButtonPressed() {
        FoodSecurityFragment foodSecurityFragment = (FoodSecurityFragment) findOrCreateViewFragment(NewDncaComponent.FOOD_SECURITY);
        mFoodSecurityViewModel = (FoodSecurityViewModel) findOrCreateViewModel(NewDncaComponent.FOOD_SECURITY);
        foodSecurityFragment.setViewModel(mFoodSecurityViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), foodSecurityFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.FOOD_SECURITY.toString());
    }

    /**
     * Show livelihoods fragment
     */
    @Override
    public void onLivelihoodsButtonPressed() {
        LivelihoodsFragment livelihoodsFragment = (LivelihoodsFragment) findOrCreateViewFragment(NewDncaComponent.LIVELIHOODS);
        mLivelihoodsViewModel = (LivelihoodsViewModel) findOrCreateViewModel(NewDncaComponent.LIVELIHOODS);
        livelihoodsFragment.setViewModel(mLivelihoodsViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), livelihoodsFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.LIVELIHOODS.toString());
    }

    /**
     * Show health fragment
     */
    @Override
    public void onHealthButtonPressed() {
        HealthFragment healthFragment = (HealthFragment) findOrCreateViewFragment(NewDncaComponent.HEALTH);
        mHealthViewModel = (HealthViewModel) findOrCreateViewModel(NewDncaComponent.HEALTH);
        healthFragment.setViewModel(mHealthViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), healthFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.HEALTH.toString());
    }

    /**
     * Show wash fragment
     */
    @Override
    public void onWashButtonPressed() {
        WashFragment washFragment = (WashFragment) findOrCreateViewFragment(NewDncaComponent.WASH);
        mWashViewModel = (WashViewModel) findOrCreateViewModel(NewDncaComponent.WASH);
        washFragment.setViewModel(mWashViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), washFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.WASH.toString());
    }

    /**
     * Show evacuation fragment
     */
    @Override
    public void onEvacuationButtonPressed() {
        EvacuationFragment evacuationFragment = (EvacuationFragment) findOrCreateViewFragment(NewDncaComponent.EVACUATION);
        mEvacuationViewModel = (EvacuationViewModel) findOrCreateViewModel(NewDncaComponent.EVACUATION);
        evacuationFragment.setViewModel(mEvacuationViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), evacuationFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.EVACUATION.toString());
    }

    /**
     * Show case stories fragment
     */
    @Override
    public void onCaseStoriesButtonPressed() {
        CaseStoriesFragment caseStoriesFragment = (CaseStoriesFragment) findOrCreateViewFragment(NewDncaComponent.CASE_STORIES);
        mCaseStoriesViewModel = (CaseStoriesViewModel) findOrCreateViewModel(NewDncaComponent.CASE_STORIES);
        caseStoriesFragment.setViewModel(mCaseStoriesViewModel);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), caseStoriesFragment,
                R.id.new_dnca_fragment_container, true, NewDncaComponent.CASE_STORIES.toString());
    }

    /**
     * Starts image capture activity
     * @param cameraOwner
     */
    @Override
    public void onCameraButtonPressed(CameraOwner cameraOwner) {
        ViewFactory.startCameraActivity(this);
        mCameraOwner = cameraOwner;
    }

    /**
     * Handles results from startActivityForResult calls
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (mCameraOwner != null) {
                mCameraOwner.addImagePath(ImageUtils.getImagePath(this, ImageUtils.getBitmapFromIntent(data)));
            }
        }
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

            case CASE_STORIES:
                if (fragment == null || !(fragment instanceof CaseStoriesFragment)) {
                    fragment = CaseStoriesFragment.newInstance();
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

                case CASE_STORIES:
                    viewModel = new CaseStoriesViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()), this);
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

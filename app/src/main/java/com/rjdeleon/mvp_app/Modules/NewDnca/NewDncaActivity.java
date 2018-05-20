package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FormDetails.NewDncaFormDetailsFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.FormDetails.NewDncaFormDetailsViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;
import com.rjdeleon.mvp_app.databinding.NewDncaActivityBinding;

public class NewDncaActivity extends AppCompatActivity implements NewDncaNavigator {

    public static final String NEW_DNCA_VIEWMODEL_TAG = "NEW_DNCA_VIEWMODEL_TAG";
    public static final String NEW_DNCA_FORM_DETAILS_VIEWMODEL_TAG = "NEW_DNCA_FORM_DETAILS_VIEWMODEL_TAG";
    public static final String NEW_DNCA_GEN_INFO_VIEWMODEL_TAG = "NEW_DNCA_GEN_INFO_VIEWMODEL_TAG";
    public static final String SHELTER_INFO_VIEWMODEL_TAG = "SHELTER_INFO_VIEWMODEL_TAG";

    private NewDncaViewModel mMainViewModel;
    private NewDncaFormDetailsViewModel mFormDetailsViewModel;
    private NewDncaGenInfoViewModel mGenInfoViewModel;
    private ShelterInfoViewModel mShelterInfoViewModel;

    private NewDncaActivityBinding mMainBinding;

    private enum NewDncaComponent {
        MENU,
        FORM_DETAILS,
        GEN_INFO,
        SHELTER_INFO
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
        NewDncaGenInfoFragment newDncaGenInfoFragment = (NewDncaGenInfoFragment) findOrCreateViewFragment(NewDncaComponent.GEN_INFO);
        mGenInfoViewModel = (NewDncaGenInfoViewModel) findOrCreateViewModel(NewDncaComponent.GEN_INFO);
        newDncaGenInfoFragment.setViewModel(mGenInfoViewModel);
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
                if (fragment == null || !(fragment instanceof NewDncaGenInfoFragment)) {
                    fragment = NewDncaGenInfoFragment.newInstance();
                }
                break;

            case SHELTER_INFO:
                if (fragment == null || !(fragment instanceof  ShelterInfoFragment)) {
                    fragment = ShelterInfoFragment.newInstance();
                }
                break;
        }

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.new_dnca_fragment_container, addToBackstack);
        return fragment;
    }

    private NewDncaBaseViewModel findOrCreateViewModel(NewDncaComponent fragmentType) {

        NewDncaBaseViewModel viewModel = null;
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
                viewModel = new NewDncaGenInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = NEW_DNCA_GEN_INFO_VIEWMODEL_TAG;
                break;

            case SHELTER_INFO:
                viewModel = new ShelterInfoViewModel(getApplicationContext(), Injection.provideDncaRepository(getApplicationContext()));
                viewModel.setNewDncaNavigator(this);
                tag = SHELTER_INFO_VIEWMODEL_TAG;
                break;
        }

        // Bind viewModel to activity's lifecycle using fragment manager
        ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(),
                ViewModelHolder.createContainer(viewModel),
                tag
        );

        return viewModel;
    }
}

package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemNavigator;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListNavigator;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewFactory;
import com.rjdeleon.mvp_app.ViewModelHolder;

public class DNCAListActivity extends AppCompatActivity implements DNCAListNavigator, DNCAListItemNavigator {

    public static final String DNCA_LIST_VIEWMODEL_TAG = "DNCA_LIST_VIEWMODEL_TAG";

    private DNCAListViewModel mViewModel;
    private ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnca_list_activity);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar_list);
        setSupportActionBar(toolbar);

        DNCAListFragment dncaListFragment = findOrCreateViewFragment();
        mViewModel = findOrCreateViewModel();
        dncaListFragment.setViewModel(mViewModel);
        mViewModel.onActivityCreated(this);

        setupBackButton();
    }

    /**
     * Finds or creates the fragment
     * @return
     */
    @NonNull
    private DNCAListFragment findOrCreateViewFragment() {

        // Get fragment
        DNCAListFragment dncaListFragment = (DNCAListFragment) getSupportFragmentManager().findFragmentById(R.id.dnca_list_container);

        if (dncaListFragment == null) {
            dncaListFragment = DNCAListFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), dncaListFragment, R.id.dnca_list_container, true);
        }

        return dncaListFragment;
    }

    /**
     * Finds or creates the viewModel
     * @return
     */
    private DNCAListViewModel findOrCreateViewModel() {

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
    }

    /**
     * Handles back button pressed action
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    /**
     * Sets up back button
     */
    public void setupBackButton() {
        mBackButton = findViewById(R.id.dnca_list_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * Navigates to new activity to show DNCA form
     * @param itemId
     */
    @Override
    public void openDncaForm(int itemId) {
        Toast.makeText(this, "Opening DNCA form...", Toast.LENGTH_SHORT).show();
    }

    /**
     * Navigates to new activity to create new DNCA form
     */
    @Override
    public void onNewDncaButtonPressed() {
        ViewFactory.startNewDncaActivity(this);
    }
}

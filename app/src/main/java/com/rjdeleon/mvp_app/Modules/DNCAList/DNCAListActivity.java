package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListNavigator;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewFactory;
import com.rjdeleon.mvp_app.ViewModelHolder;
import com.rjdeleon.mvp_app.databinding.DncaListActivityBinding;

public class DNCAListActivity extends AppCompatActivity implements DNCAListNavigator {

    public static final String DNCA_LIST_VIEWMODEL_TAG = "DNCA_LIST_VIEWMODEL_TAG";

    private DNCAListViewModel mViewModel;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

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

        /*
        mPresenter = new DNCAListPresenter(this);
        DncaListActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.dnca_list_activity);
        binding.setPresenter(this.mPresenter);


        // Initialize adapter
        mAdapter = new DNCAListAdapter(mPresenter);

        // Initialize RecyclerView
        mRecyclerView = findViewById(R.id.dnca_list_view);
        mRecyclerView.setHasFixedSize(true);

        // Add horizontal dividers in Recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        mRecyclerView.setAdapter(mAdapter);
        */
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
}

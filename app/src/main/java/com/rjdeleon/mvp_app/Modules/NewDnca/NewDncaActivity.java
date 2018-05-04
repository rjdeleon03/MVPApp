package com.rjdeleon.mvp_app.Modules.NewDnca;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Utils.ActivityUtils;
import com.rjdeleon.mvp_app.ViewModelHolder;
import com.rjdeleon.mvp_app.databinding.NewDncaActivityBinding;

public class NewDncaActivity extends AppCompatActivity implements NewDncaNavigator {

    public static final String NEW_DNCA_VIEWMODEL_TAG = "NEW_DNCA_VIEWMODEL_TAG";

    private NewDncaViewModel mViewModel;

    private NewDncaActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.new_dnca_activity);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar_new_dnca);
        setSupportActionBar(toolbar);

        // Setup view and viewModel
        NewDncaFragment newDncaFragment = findOrCreateViewFragment();
        mViewModel = findOrCreateViewModel();

        // Link view and viewModel
        newDncaFragment.setViewModel(mViewModel);
        mViewModel.setNavigator(this);

        // Bind viewModel to view
        mBinding.setViewModel(mViewModel);
    }

    @Override
    public void onBackButtonPressed() {
        onBackPressed();
    }

    @NonNull
    private NewDncaFragment findOrCreateViewFragment() {

        // Retrieve fragment if it exists
        NewDncaFragment newDncaFragment = (NewDncaFragment)getSupportFragmentManager().
                findFragmentById(R.id.new_dnca_fragment_container);

        if (newDncaFragment == null) {
            newDncaFragment = NewDncaFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), newDncaFragment, R.id.new_dnca_fragment_container);
        }
        return newDncaFragment;
    }

    private NewDncaViewModel findOrCreateViewModel() {

        // TODO: Restore view model for config change
        // Create viewModel
        NewDncaViewModel viewModel = new NewDncaViewModel(getApplicationContext());

        // Bind viewModel to activity's lifecycle using fragment manager
        ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(),
                ViewModelHolder.createContainer(viewModel),
                NEW_DNCA_VIEWMODEL_TAG
        );

        return viewModel;
    }
}

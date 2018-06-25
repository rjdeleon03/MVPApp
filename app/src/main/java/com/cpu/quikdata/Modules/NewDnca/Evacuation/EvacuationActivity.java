package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.R;
import com.cpu.quikdata.ViewFactory;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.EVACUATION_LIST;

public class EvacuationActivity extends AppCompatActivity {

    private EvacuationListViewModel mViewModel;
    private ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evacuation_activity);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar_list);
        setSupportActionBar(toolbar);

        // Setup fragment and viewModel
        EvacuationListFragment evacuationListFragment =
                (EvacuationListFragment)ViewFactory.findOrCreateViewFragment(getSupportFragmentManager(), EVACUATION_LIST);
        mViewModel =
                (EvacuationListViewModel)ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), EVACUATION_LIST, null, this);
        evacuationListFragment.setViewModel(mViewModel);

        setupBackButton();
    }

    /**
     * Handles back button pressed action
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
}

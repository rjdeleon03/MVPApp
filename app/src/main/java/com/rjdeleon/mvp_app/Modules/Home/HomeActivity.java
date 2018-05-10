package com.rjdeleon.mvp_app.Modules.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.ViewFactory;

public class HomeActivity extends AppCompatActivity {

    private ImageButton mDncaListButton;
    private ImageButton mSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        // Setup the toolbar
        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar);
        setSupportActionBar(toolbar);

        // Setup the DNCA list button
        setupDncaListButton();
    }

    /**
     * Setup DNCA list button
     */
    private void setupDncaListButton() {
        mDncaListButton = findViewById(R.id.home_dnca_list_button);
        mDncaListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDncaList();
            }
        });
    }

    /**
     * Navigate to DNCA list activity
     */
    private void navigateToDncaList() {
        ViewFactory.startDNCAListActivity(this);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}

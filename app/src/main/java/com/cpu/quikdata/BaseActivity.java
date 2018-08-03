package com.cpu.quikdata;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected static final int TOOLBAR_ID = R.id.custom_nav_toolbar_list;
    protected String mToolbarTitle = "";

    /**
     * Sets up the toolbar
     * @param enableUpButton
     */
    protected void setupToolbar(boolean enableUpButton) {

        if (mToolbar == null) {
            mToolbar = findViewById(TOOLBAR_ID);
        }
        if (!mToolbarTitle.isEmpty()) {
            mToolbar.setTitle(mToolbarTitle);
        }
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(enableUpButton);
        }
    }

    /**
     * Inflates the menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_toolbar_menu, menu);
        return true;
    }

    /**
     * Handles actions triggered by user
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_action_settings:
                ViewFactory.startPrefilledActivity(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

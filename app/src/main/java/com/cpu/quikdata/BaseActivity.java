package com.cpu.quikdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;

import java.io.FileReader;

import io.realm.Realm;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected static final int TOOLBAR_ID = R.id.custom_nav_toolbar_list;
    private String mToolbarTitle;
    private int mToolbarTitleId = -1;
    private int mFragmentContainerId;
    protected Realm mRealm;

    public BaseActivity(String toolbarTitle, int fragmentContainerId) {
        mToolbarTitle = toolbarTitle;
        mFragmentContainerId = fragmentContainerId;
    }

    public BaseActivity(int toolbarTitleId, int fragmentContainerId) {
        mToolbarTitleId = toolbarTitleId;
        mFragmentContainerId = fragmentContainerId;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setup realm
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    protected void onDestroy() {
        mRealm.close();
        super.onDestroy();
    }

    /**
     * Sets up the toolbar
     * @param enableUpButton
     */
    protected void setupToolbar(boolean enableUpButton) {

        // Find toolbar
        if (mToolbar == null) {
            mToolbar = findViewById(TOOLBAR_ID);
        }

        // Set title
        if (!mToolbarTitle.isEmpty()){
            mToolbar.setTitle(mToolbarTitle);
        }

        // Set toolbar as action bar
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

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        setToolbarTitleFromFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setToolbarTitleFromFragment(getSupportFragmentManager().findFragmentById(mFragmentContainerId));
        setToolbarSubtitle(null);
    }

    /**
     * Sets the toolbar title based on the topmost fragment
     */
    public void setToolbarTitleFromFragment(Fragment fragment) {
        if (fragment instanceof BaseFragment) {
            // TODO: Use correct string as fragment title (probably mapping)
            if (mToolbar != null) {
                String fragmentTitle = ((BaseFragment) fragment).getType();
                if (fragmentTitle == null || fragmentTitle.isEmpty()) {
                    mToolbar.setTitle(R.string.app_name);
                } else {
                    mToolbar.setTitle(fragmentTitle);
                }
            }
        }
    }

    public void setToolbarSubtitle(String subtitle) {
        if (mToolbar != null) {
            mToolbar.setSubtitle(subtitle);
        }
    }
}

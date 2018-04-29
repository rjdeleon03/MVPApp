package com.rjdeleon.mvp_app.Views.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Presenters.NewFormPresenter;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;
import com.rjdeleon.mvp_app.Views.Fragments.NewFormMenuFragment;
import com.rjdeleon.mvp_app.databinding.NewFormActivityBinding;

public class NewFormActivity extends AppCompatActivity implements NewFormContract.View {

    NewFormPresenter mPresenter;
    NewFormMenuFragment mMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        this.mPresenter = new NewFormPresenter(this);
        NewFormActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.new_form_activity);
        binding.setPresenter(mPresenter);

        this.mMenuFragment = new NewFormMenuFragment();
        mMenuFragment.attachPresenter(mPresenter);

        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.new_form_fragment_container, mMenuFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            // If back stack is not empty, go back to previous frame
            closeFragment();

        } else {
            // Else, revert to previous activity
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public void onSwitchToFragment(BaseFragment fragment) {

        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.new_form_fragment_container, fragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void onCloseFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        closeFragment();
    }

    @Override
    public void onBackButtonClicked(View view) {
        onBackPressed();
    }

    private void closeFragment() {

        // Pop topmost fragment from stackcloseFragment
        getSupportFragmentManager().popBackStackImmediate();

        // Hide keyboard
        AppUtil.hideSoftKeyboard(this);
    }
}

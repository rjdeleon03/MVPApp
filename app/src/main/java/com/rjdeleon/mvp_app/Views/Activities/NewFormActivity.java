package com.rjdeleon.mvp_app.Views.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Presenters.NewFormDetailsPresenter;
import com.rjdeleon.mvp_app.Presenters.NewFormPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;
import com.rjdeleon.mvp_app.Views.Fragments.NewFormDetailsFragment;
import com.rjdeleon.mvp_app.Views.Fragments.NewFormMenuFragment;

public class NewFormActivity extends AppCompatActivity implements NewFormContract.View {

    NewFormPresenter mPresenter;
    NewFormMenuFragment mMenuFragment;

    NewFormDetailsPresenter mDetailsPresenter;
    NewFormDetailsFragment mDetailsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        this.mMenuFragment = new NewFormMenuFragment();
        this.mPresenter = new NewFormPresenter(this);
        mMenuFragment.attachPresenter(mPresenter);

        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.new_form_fragment_container, mMenuFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onSwitchToFragment(BaseFragment fragment) {

        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.new_form_fragment_container, fragment).commit();
        }

    }
}

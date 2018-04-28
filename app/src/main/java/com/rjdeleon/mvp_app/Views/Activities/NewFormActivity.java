package com.rjdeleon.mvp_app.Views.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Presenters.NewFormDetailsPresenter;
import com.rjdeleon.mvp_app.Presenters.NewFormPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.NewFormDetailsFragment;
import com.rjdeleon.mvp_app.Views.Fragments.NewFormMenuFragment;
import com.rjdeleon.mvp_app.databinding.NewFormMenuFragmentBinding;

public class NewFormActivity extends AppCompatActivity {

    NewFormMenuFragment mMenuFragment;

    NewFormDetailsPresenter mDetailsPresenter;
    NewFormDetailsFragment mDetailsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        this.mMenuFragment = new NewFormMenuFragment();

        if(findViewById(R.id.new_form_fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.new_form_fragment_container, mMenuFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

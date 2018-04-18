package com.rjdeleon.mvp_app.Views.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rjdeleon.mvp_app.Contracts.HomeContract;
import com.rjdeleon.mvp_app.Presenters.HomePresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.HomeActivityBinding;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {


    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mPresenter = new HomePresenter(this);
        HomeActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.home_activity);
        binding.setPresenter(this.mPresenter);
    }

    @Override
    public void navigateToNewDnca() { // Start New DNCA Activity
        Toast.makeText(this, "Loading new DNCA form...", Toast.LENGTH_SHORT).show();

        DNCAListActivity.startActivity(this);
    }
}

package com.rjdeleon.mvp_app.Views.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rjdeleon.mvp_app.Contracts.DNCAListContract;
import com.rjdeleon.mvp_app.Presenters.DNCAListPresenter;
import com.rjdeleon.mvp_app.R;

public class DNCAListActivity extends AppCompatActivity implements DNCAListContract.View {

    private DNCAListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DNCAListPresenter(this);
        setContentView(R.layout.dnca_list_activity);
    }
}

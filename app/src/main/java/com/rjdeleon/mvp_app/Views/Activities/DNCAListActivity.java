package com.rjdeleon.mvp_app.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.rjdeleon.mvp_app.Contracts.DNCAListContract;
import com.rjdeleon.mvp_app.Presenters.DNCAListPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DncaListActivityBinding;

public class DNCAListActivity extends AppCompatActivity implements DNCAListContract.View {

    private DNCAListPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DNCAListPresenter(this);
        DncaListActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.dnca_list_activity);
//        binding.
        binding.setPresenter(this.mPresenter);


        Toolbar toolbar = findViewById(R.id.custom_nav_toolbar_list);
        setSupportActionBar(toolbar);

        // Initialize adapter
        mAdapter = new DNCAListAdapter(mPresenter);

        // Initialize RecyclerView
        mRecyclerView = findViewById(R.id.dncaList);
        mRecyclerView.setHasFixedSize(true);

        // Add horizontal dividers in Recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getAllDncaForms();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void onBackButtonClick() {
        onBackPressed();
    }

    @Override
    public void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void displayShortToast(String message) {
        final String fMessage = message;
        final Context fContext = this;
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(fContext, fMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

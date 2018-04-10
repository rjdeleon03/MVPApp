package com.rjdeleon.mvp_app.Views.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.Contracts.DNCAListContract;
import com.rjdeleon.mvp_app.Presenters.DNCAListPresenter;
import com.rjdeleon.mvp_app.R;

public class DNCAListActivity extends AppCompatActivity implements DNCAListContract.View {

    private DNCAListPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DNCAListPresenter();
        setContentView(R.layout.dnca_list_activity);

        mAdapter = new DNCAListAdapter(mPresenter);

        mRecyclerView = findViewById(R.id.dncaList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(mAdapter);
    }
}

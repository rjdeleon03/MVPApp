package com.rjdeleon.mvp_app.Views.Activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Presenters.DNCAListPresenter;
import com.rjdeleon.mvp_app.R;

public class DNCAListAdapter extends RecyclerView.Adapter<DNCAListItemViewHolder>{

    private DNCAListPresenter mPresenter;

    public DNCAListAdapter(DNCAListPresenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public DNCAListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dnca_list_item, parent, false);
        return new DNCAListItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DNCAListItemViewHolder holder, int position) {
        mPresenter.onBindItemViewAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getItemsCount();
    }
}

package com.rjdeleon.mvp_app.Views.Activities;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Presenters.DNCAListPresenter;
import com.rjdeleon.mvp_app.Presenters.HomePresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DncaListItemBinding;
import com.rjdeleon.mvp_app.databinding.HomeActivityBinding;

public class DNCAListAdapter extends RecyclerView.Adapter<DNCAListItemViewHolder>{

    private DNCAListPresenter mPresenter;

    public DNCAListAdapter(DNCAListPresenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public DNCAListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DncaListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.dnca_list_item, parent, false);

        return new DNCAListItemViewHolder(binding);
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

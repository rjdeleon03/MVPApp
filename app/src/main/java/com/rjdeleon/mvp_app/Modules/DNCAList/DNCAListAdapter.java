package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemViewHolder;
import com.rjdeleon.mvp_app.databinding.DncaListItemBinding;

public class DNCAListAdapter extends RecyclerView.Adapter<DNCAListItemViewHolder>{

    private DNCAListViewModel mViewModel;

    public DNCAListAdapter(DNCAListViewModel viewModel) {
        mViewModel = viewModel;
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
        DNCAListItem dncaListItem = mViewModel.getDncaForm(position);
        holder.setHead(dncaListItem.getSitio());
        holder.setDesc(dncaListItem.getBarangay());
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDncaFormsCount();
    }
}

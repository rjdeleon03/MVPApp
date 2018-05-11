package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Models.DNCAListItem;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemNavigator;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListItemViewHolder;
import com.rjdeleon.mvp_app.databinding.DncaListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class DNCAListAdapter extends RecyclerView.Adapter<DNCAListItemViewHolder>{

    private DNCAListViewModel mViewModel;
    private List<DNCAListItem> mItems;
    private DNCAListItemNavigator mNavigator;

    public DNCAListAdapter(DNCAListViewModel viewModel, DNCAListItemNavigator navigator) {
        mViewModel = viewModel;
        mItems = new ArrayList<>();
        mNavigator = navigator;
    }

    /**
     * Replace DNCA list items to update
     * @param items
     */
    public void replaceItems(List<DNCAListItem> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DNCAListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.dnca_list_item, parent, false);
        DncaListItemBinding binding = DncaListItemBinding.bind(root);

        final DNCAListItemViewModel viewModel = new DNCAListItemViewModel(
                parent.getContext().getApplicationContext(),
                Injection.provideDncaRepository(parent.getContext().getApplicationContext()));
        viewModel.setNavigator(mNavigator);
        binding.setViewModel(viewModel);

        return new DNCAListItemViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull DNCAListItemViewHolder holder, int position) {
        DNCAListItem dncaListItem = mItems.get(position);
        holder.setHead(dncaListItem.getSitio());
        holder.setDesc(dncaListItem.getBarangay());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.HouseDamageRowBinding;

public class HouseDamageRowViewHolder extends RecyclerView.ViewHolder {

    private HouseDamageRowBinding mBinding;

    public HouseDamageRowViewHolder(HouseDamageRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(HouseDamageRowViewModel houseDamageRowViewModel) {
        mBinding.setViewModel(houseDamageRowViewModel);
    }
}

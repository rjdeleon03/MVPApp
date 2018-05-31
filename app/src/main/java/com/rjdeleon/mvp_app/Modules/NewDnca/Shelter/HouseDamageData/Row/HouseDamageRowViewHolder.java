package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.ShelterHouseDamageRowBinding;

public class HouseDamageRowViewHolder extends RecyclerView.ViewHolder {

    private ShelterHouseDamageRowBinding mBinding;

    public HouseDamageRowViewHolder(ShelterHouseDamageRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(HouseDamageRowViewModel houseDamageRowViewModel) {
        mBinding.setViewModel(houseDamageRowViewModel);
    }
}

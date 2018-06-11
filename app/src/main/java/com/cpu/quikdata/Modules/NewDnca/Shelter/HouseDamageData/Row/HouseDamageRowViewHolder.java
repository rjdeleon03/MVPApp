package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Row;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.databinding.ShelterHouseDamageRowBinding;

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

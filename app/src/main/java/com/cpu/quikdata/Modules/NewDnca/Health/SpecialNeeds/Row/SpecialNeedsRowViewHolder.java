package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.databinding.HealthSpecialNeedsRowBinding;

public class SpecialNeedsRowViewHolder extends RecyclerView.ViewHolder {

    private HealthSpecialNeedsRowBinding mBinding;

    public SpecialNeedsRowViewHolder(HealthSpecialNeedsRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(SpecialNeedsRowViewModel specialNeedsRowViewModel) {
        mBinding.setViewModel(specialNeedsRowViewModel);
    }
}

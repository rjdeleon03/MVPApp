package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Row;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.databinding.DeathCauseDataRowBinding;

public class DeathCauseDataRowViewHolder extends RecyclerView.ViewHolder {

    private DeathCauseDataRowBinding mBinding;

    public DeathCauseDataRowViewHolder(DeathCauseDataRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(DeathCauseDataRowViewModel deathCauseDataRowViewModel) {
        mBinding.setViewModel(deathCauseDataRowViewModel);
    }
}

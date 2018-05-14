package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.DeathCauseDataRowBinding;

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

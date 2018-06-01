package com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.HealthPsychosocialRowBinding;

public class PsychosocialRowViewHolder extends RecyclerView.ViewHolder {

    private HealthPsychosocialRowBinding mBinding;

    public PsychosocialRowViewHolder(HealthPsychosocialRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(PsychosocialRowViewModel psychosocialRowViewModel) {
        mBinding.setViewModel(psychosocialRowViewModel);
    }
}

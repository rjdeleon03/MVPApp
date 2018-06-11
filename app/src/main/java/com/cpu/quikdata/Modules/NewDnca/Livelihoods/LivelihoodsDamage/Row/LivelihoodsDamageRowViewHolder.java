package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.databinding.LivelihoodsDamageRowBinding;

public class LivelihoodsDamageRowViewHolder extends RecyclerView.ViewHolder {

    private LivelihoodsDamageRowBinding mBinding;

    public LivelihoodsDamageRowViewHolder(LivelihoodsDamageRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(LivelihoodsDamageRowViewModel livelihoodsDamageRowViewModel) {
        mBinding.setViewModel(livelihoodsDamageRowViewModel);
    }
}

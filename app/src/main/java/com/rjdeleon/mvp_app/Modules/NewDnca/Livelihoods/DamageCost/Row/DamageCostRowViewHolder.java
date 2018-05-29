package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.LivelihoodsDamageRowBinding;

public class DamageCostRowViewHolder extends RecyclerView.ViewHolder {

    private LivelihoodsDamageRowBinding mBinding;

    public DamageCostRowViewHolder(LivelihoodsDamageRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(DamageCostRowViewModel damageCostRowViewModel) {
        mBinding.setViewModel(damageCostRowViewModel);
    }
}

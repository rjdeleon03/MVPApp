package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.EvacuationPopulationRowBinding;

public class EvacuationPopulationRowViewHolder extends RecyclerView.ViewHolder {

    public EvacuationPopulationRowBinding mBinding;

    public EvacuationPopulationRowViewHolder(EvacuationPopulationRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(EvacuationPopulationRowViewModel evacuationPopulationRowViewModel) {
        mBinding.setViewModel(evacuationPopulationRowViewModel);
    }
}

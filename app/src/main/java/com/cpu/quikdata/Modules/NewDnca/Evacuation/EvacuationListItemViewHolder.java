package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.databinding.EvacuationListItemBinding;

public class EvacuationListItemViewHolder extends RecyclerView.ViewHolder {

    private EvacuationListItemBinding mBinding;

    public EvacuationListItemViewHolder(EvacuationListItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(EvacuationListItemViewModel viewModel) {
        mBinding.setViewModel(viewModel);
    }
}

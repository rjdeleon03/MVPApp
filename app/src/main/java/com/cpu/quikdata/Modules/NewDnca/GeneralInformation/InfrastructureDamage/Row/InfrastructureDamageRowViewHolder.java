package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.databinding.InfrastructureDamageRowBinding;

public class InfrastructureDamageRowViewHolder extends RecyclerView.ViewHolder {

    private InfrastructureDamageRowBinding mBinding;

    public InfrastructureDamageRowViewHolder(InfrastructureDamageRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(InfrastructureDamageRowViewModel infrastructureDamageRowViewModel) {
        mBinding.setViewModel(infrastructureDamageRowViewModel);
    }
}

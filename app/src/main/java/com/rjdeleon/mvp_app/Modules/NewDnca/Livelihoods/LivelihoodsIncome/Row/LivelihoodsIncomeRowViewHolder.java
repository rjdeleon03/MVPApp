package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.IncomeSourceRowBinding;

public class LivelihoodsIncomeRowViewHolder extends RecyclerView.ViewHolder {

    private IncomeSourceRowBinding mBinding;

    public LivelihoodsIncomeRowViewHolder(IncomeSourceRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(LivelihoodsIncomeRowViewModel livelihoodsIncomeRowViewModel) {
        mBinding.setViewModel(livelihoodsIncomeRowViewModel);
    }
}

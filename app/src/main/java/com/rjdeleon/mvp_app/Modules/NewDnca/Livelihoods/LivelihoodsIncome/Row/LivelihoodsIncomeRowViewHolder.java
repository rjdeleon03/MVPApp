package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.LivelihoodsIncomeSourceRowBinding;

public class LivelihoodsIncomeRowViewHolder extends RecyclerView.ViewHolder {

    private LivelihoodsIncomeSourceRowBinding mBinding;

    public LivelihoodsIncomeRowViewHolder(LivelihoodsIncomeSourceRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(LivelihoodsIncomeRowViewModel livelihoodsIncomeRowViewModel) {
        mBinding.setViewModel(livelihoodsIncomeRowViewModel);
    }
}

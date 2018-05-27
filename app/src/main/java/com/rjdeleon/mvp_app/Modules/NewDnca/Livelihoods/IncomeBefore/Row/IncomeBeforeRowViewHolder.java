package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.IncomeSourceRowBinding;

public class IncomeBeforeRowViewHolder extends RecyclerView.ViewHolder {

    private IncomeSourceRowBinding mBinding;

    public IncomeBeforeRowViewHolder(IncomeSourceRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(IncomeBeforeRowViewModel incomeBeforeRowViewModel) {
        mBinding.setViewModel(incomeBeforeRowViewModel);
    }
}

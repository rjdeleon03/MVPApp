package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.AssistanceRowBinding;

public class AssistanceRowViewHolder extends RecyclerView.ViewHolder {

    private AssistanceRowBinding mBinding;

    public AssistanceRowViewHolder(AssistanceRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(AssistanceRowViewModel assistanceRowViewModel) {
        mBinding.setViewModel(assistanceRowViewModel);
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.BaseCheckboxBinding;

public class LivelihoodsDamageCheckboxViewHolder extends RecyclerView.ViewHolder {

    private BaseCheckboxBinding mBinding;

    public LivelihoodsDamageCheckboxViewHolder(BaseCheckboxBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(LivelihoodsDamageCheckboxViewModel livelihoodsDamageCheckboxViewModel) {
        mBinding.setViewModel(livelihoodsDamageCheckboxViewModel);
    }
}

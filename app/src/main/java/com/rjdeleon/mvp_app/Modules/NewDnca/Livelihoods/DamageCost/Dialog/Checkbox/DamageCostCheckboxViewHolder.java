package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.BaseCheckboxBinding;

public class DamageCostCheckboxViewHolder extends RecyclerView.ViewHolder {

    private BaseCheckboxBinding mBinding;

    public DamageCostCheckboxViewHolder(BaseCheckboxBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(DamageCostCheckboxViewModel damageCostCheckboxViewModel) {
        mBinding.setViewModel(damageCostCheckboxViewModel);
    }
}

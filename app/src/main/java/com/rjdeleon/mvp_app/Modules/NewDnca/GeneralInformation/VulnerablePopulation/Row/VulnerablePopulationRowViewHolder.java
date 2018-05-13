package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row;

import android.support.v7.widget.RecyclerView;
import com.rjdeleon.mvp_app.databinding.VulnerablePopulationRowBinding;

public class VulnerablePopulationRowViewHolder extends RecyclerView.ViewHolder {

    private VulnerablePopulationRowBinding mBinding;

    public VulnerablePopulationRowViewHolder(VulnerablePopulationRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(VulnerablePopulationRowViewModel vulnerablePopulationRowViewModel) {
        mBinding.setViewModel(vulnerablePopulationRowViewModel);
    }
}

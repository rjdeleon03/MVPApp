package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.PopulationDataRowBinding;

public class PopulationDataRowViewHolder extends RecyclerView.ViewHolder {

    private PopulationDataRowBinding mBinding;

    public PopulationDataRowViewHolder(PopulationDataRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(PopulationDataRowViewModel populationDataRowViewModel) {
        mBinding.setViewModel(populationDataRowViewModel);
    }
}

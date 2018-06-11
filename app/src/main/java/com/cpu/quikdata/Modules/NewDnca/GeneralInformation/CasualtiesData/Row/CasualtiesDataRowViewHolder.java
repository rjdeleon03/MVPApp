package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.databinding.CasualtiesDataRowBinding;

public class CasualtiesDataRowViewHolder extends RecyclerView.ViewHolder {

    private CasualtiesDataRowBinding mBinding;

    public CasualtiesDataRowViewHolder(CasualtiesDataRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(CasualtiesDataRowViewModel casualtiesDataRowViewModel) {
        mBinding.setViewModel(casualtiesDataRowViewModel);
    }
}

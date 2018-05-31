package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.ShelterNeedsRowBinding;

public class ShelterNeedsRowViewHolder extends RecyclerView.ViewHolder {

    private ShelterNeedsRowBinding mBinding;

    public ShelterNeedsRowViewHolder(ShelterNeedsRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(ShelterNeedsRowViewModel shelterNeedsRowViewModel) {
        mBinding.setViewModel(shelterNeedsRowViewModel);
    }
}

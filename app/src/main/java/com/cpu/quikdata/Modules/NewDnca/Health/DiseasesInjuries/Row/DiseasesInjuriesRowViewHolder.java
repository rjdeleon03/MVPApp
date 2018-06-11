package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.databinding.HealthDiseasesInjuriesRowBinding;

public class DiseasesInjuriesRowViewHolder extends RecyclerView.ViewHolder {

    private HealthDiseasesInjuriesRowBinding mBinding;

    public DiseasesInjuriesRowViewHolder(HealthDiseasesInjuriesRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(DiseasesInjuriesRowViewModel diseasesInjuriesRowViewModel) {
        mBinding.setViewModel(diseasesInjuriesRowViewModel);
    }
}

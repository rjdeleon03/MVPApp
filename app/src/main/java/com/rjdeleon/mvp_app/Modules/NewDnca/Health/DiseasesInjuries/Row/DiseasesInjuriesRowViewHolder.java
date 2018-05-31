package com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rjdeleon.mvp_app.databinding.HealthDiseasesInjuriesRowBinding;

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

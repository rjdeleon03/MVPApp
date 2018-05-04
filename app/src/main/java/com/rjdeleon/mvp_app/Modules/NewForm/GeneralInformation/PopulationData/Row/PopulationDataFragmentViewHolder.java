package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.Row;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.PopulationDataRowV1Binding;

public class PopulationDataFragmentViewHolder extends RecyclerView.ViewHolder implements PopulationDataRowContract.View {

    private final PopulationDataRowV1Binding mBinding;

    public PopulationDataFragmentViewHolder(PopulationDataRowV1Binding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    @Override
    public void bind(PopulationDataRowContract.Presenter presenter) {
        mBinding.setPresenter((PopulationDataRowPresenter) presenter);
    }
}

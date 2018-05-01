package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;

import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataRowContract;
import com.rjdeleon.mvp_app.Presenters.GeneralInformation.PopulationDataRowPresenter;
import com.rjdeleon.mvp_app.databinding.PopulationDataRowBinding;

public class PopulationDataFragmentViewHolder extends RecyclerView.ViewHolder implements PopulationDataRowContract.View {

    private final PopulationDataRowBinding mBinding;

    public PopulationDataFragmentViewHolder(PopulationDataRowBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    @Override
    public void bind(PopulationDataRowContract.Presenter presenter) {
        mBinding.setPresenter((PopulationDataRowPresenter) presenter);
    }
}

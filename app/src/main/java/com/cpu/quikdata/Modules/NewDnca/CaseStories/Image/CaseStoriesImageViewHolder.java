package com.cpu.quikdata.Modules.NewDnca.CaseStories.Image;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpu.quikdata.databinding.CaseImageItemBinding;

public class CaseStoriesImageViewHolder extends RecyclerView.ViewHolder {

    private CaseImageItemBinding mBinding;
    private CaseStoriesImageViewModel mViewModel;

    public CaseStoriesImageViewHolder(CaseImageItemBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(CaseStoriesImageViewModel viewModel) {
        mViewModel = viewModel;
        mBinding.setViewModel(viewModel);
    }
}

package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Row;

import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.databinding.FormInterviewRowBinding;

public class InterviewDetailsRowViewHolder extends RecyclerView.ViewHolder {

    private FormInterviewRowBinding mBinding;
    private InterviewDetailsRowViewModel mViewModel;

    public InterviewDetailsRowViewHolder(FormInterviewRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(InterviewDetailsRowViewModel interviewDetailsRowViewModel) {
        mViewModel = interviewDetailsRowViewModel;
        mBinding.setViewModel(mViewModel);
    }
}

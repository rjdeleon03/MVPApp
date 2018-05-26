package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.Row;

import android.app.DatePickerDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.AssistanceRowBinding;

public class AssistanceRowViewHolder extends RecyclerView.ViewHolder {

    private AssistanceRowBinding mBinding;
    private AssistanceRowViewModel mViewModel;

    public AssistanceRowViewHolder(AssistanceRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(AssistanceRowViewModel assistanceRowViewModel) {
        mViewModel = assistanceRowViewModel;
        mBinding.setViewModel(mViewModel);
    }
}

package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row;

import android.app.DatePickerDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.AssistanceRowBinding;

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

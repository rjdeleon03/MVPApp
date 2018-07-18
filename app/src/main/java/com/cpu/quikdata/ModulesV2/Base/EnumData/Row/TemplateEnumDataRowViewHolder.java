package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TableLayout;

import com.cpu.quikdata.databinding.TemplateEnumDataRowBinding;

public class TemplateEnumDataRowViewHolder<VM extends TemplateEnumDataRowViewModel> extends RecyclerView.ViewHolder {

    private TemplateEnumDataRowBinding mBinding;

    public TemplateEnumDataRowViewHolder(View itemView) {
        super(itemView);
        bind(itemView);
    }

    public void bind(View itemView) {
        mBinding = TemplateEnumDataRowBinding.bind(itemView);
    }

    public void setViewModel(VM viewModel) {
        mBinding.setViewModel(viewModel);
    }
}

package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashConditions.Questions;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.WashConditionsIntBinding;
import com.rjdeleon.mvp_app.databinding.WashConditionsLevelsBinding;
import com.rjdeleon.mvp_app.databinding.WashConditionsStringBinding;
import com.rjdeleon.mvp_app.databinding.WashConditionsBooleanBinding;

public class WashConditionsItemViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mBinding;

    public WashConditionsItemViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(WashConditionsItemViewModelBase washConditionsItemViewModel) {

        if (washConditionsItemViewModel instanceof WashConditionsItemViewModelString) {
            ((WashConditionsStringBinding) mBinding).setViewModel((WashConditionsItemViewModelString) washConditionsItemViewModel);

        } else if (washConditionsItemViewModel instanceof WashConditionsItemViewModelInt) {
            ((WashConditionsIntBinding) mBinding).setViewModel((WashConditionsItemViewModelInt) washConditionsItemViewModel);

        } else if (washConditionsItemViewModel instanceof WashConditionsItemViewModelBoolean) {
            ((WashConditionsBooleanBinding) mBinding).setViewModel((WashConditionsItemViewModelBoolean) washConditionsItemViewModel);

        } else if (washConditionsItemViewModel instanceof WashConditionsItemViewModelLevels) {
            ((WashConditionsLevelsBinding) mBinding).setViewModel((WashConditionsItemViewModelLevels) washConditionsItemViewModel);

        }
    }
}

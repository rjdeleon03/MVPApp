package com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.rjdeleon.mvp_app.databinding.BaseQuestionIntBinding;
import com.rjdeleon.mvp_app.databinding.BaseQuestionLevelsBinding;
import com.rjdeleon.mvp_app.databinding.BaseQuestionStringBinding;
import com.rjdeleon.mvp_app.databinding.BaseQuestionBooleanBinding;

public class QuestionItemViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mBinding;

    public QuestionItemViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(QuestionItemViewModel washConditionsItemViewModel) {

        if (washConditionsItemViewModel instanceof QuestionItemViewModelString) {
            ((BaseQuestionStringBinding) mBinding).setViewModel((QuestionItemViewModelString) washConditionsItemViewModel);

        } else if (washConditionsItemViewModel instanceof QuestionItemViewModelInt) {
            ((BaseQuestionIntBinding) mBinding).setViewModel((QuestionItemViewModelInt) washConditionsItemViewModel);

        } else if (washConditionsItemViewModel instanceof QuestionItemViewModelBoolean) {
            ((BaseQuestionBooleanBinding) mBinding).setViewModel((QuestionItemViewModelBoolean) washConditionsItemViewModel);

        } else if (washConditionsItemViewModel instanceof QuestionItemViewModelLevels) {
            ((BaseQuestionLevelsBinding) mBinding).setViewModel((QuestionItemViewModelLevels) washConditionsItemViewModel);

        }
    }
}

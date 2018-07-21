package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableBoolean;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;

public class TemplateQuestionItemViewModelBoolean extends TemplateQuestionItemViewModel<QuestionItemModelBoolean> {

    public final ObservableBoolean value = new ObservableBoolean(false);

    public TemplateQuestionItemViewModelBoolean(QuestionItemModelBoolean model) {
        super(model);
        question.set(mModel.getQuestion());
        value.set(mModel.getValue());
    }

    @Override
    public QuestionItemModelBoolean getModel() {
        return new QuestionItemModelBoolean(question.get(), value.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.BOOLEAN;
    }

    @Override
    public void updateModel() {
        mModel.setValue(value.get());
    }
}

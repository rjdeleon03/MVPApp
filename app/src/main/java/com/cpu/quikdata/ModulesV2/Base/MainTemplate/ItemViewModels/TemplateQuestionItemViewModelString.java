package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableField;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

public class TemplateQuestionItemViewModelString extends TemplateQuestionItemViewModel<QuestionItemModelString> {

    public final ObservableField<String> value = new ObservableField<>("");

    public TemplateQuestionItemViewModelString(QuestionItemModelString model) {
        super(model);
//        question.set(TextUtils.textMap.get(mModel.getQuestion()));
        question.set(mModel.getQuestion());
        value.set(mModel.getValue());
    }

    @Override
    public QuestionItemModelString getModel() {
        return new QuestionItemModelString(question.get(), value.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.STRING;
    }

    @Override
    public void updateModel() {
        mModel.setValue(value.get());
    }
}

package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;

public class TemplateQuestionItemViewModelBooleanString extends TemplateQuestionItemViewModel<QuestionItemModelBooleanString> {

    public final ObservableBoolean value = new ObservableBoolean(false);
    public final ObservableField<String> remarksQuestion = new ObservableField<>("");
    public final ObservableField<String> remarks = new ObservableField<>("");

    public TemplateQuestionItemViewModelBooleanString(QuestionItemModelBooleanString model) {
        super(model);
        question.set(mModel.getQuestion());
        value.set(mModel.getValue());
        remarksQuestion.set(mModel.getRemarksQuestion());
        remarks.set(mModel.getRemarks());
    }

    @Override
    public QuestionItemModelBooleanString getModel() {
        return new QuestionItemModelBooleanString(question.get(), value.get(), remarksQuestion.get(), remarks.get());
    }

    @Override
    public AppConstants.QuestionItemType getType() {
        return AppConstants.QuestionItemType.BOOLEAN_STRING;
    }

    @Override
    public void updateModel() {
        mModel.setValue(value.get());
    }
}

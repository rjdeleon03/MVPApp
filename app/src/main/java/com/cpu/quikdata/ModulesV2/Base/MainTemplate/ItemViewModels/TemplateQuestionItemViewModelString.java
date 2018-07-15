package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableField;

import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

public class TemplateQuestionItemViewModelString extends TemplateQuestionItemViewModel {

    public final ObservableField<String> value = new ObservableField<>("");

    public TemplateQuestionItemViewModelString(QuestionItemModelString model) {
        super(model.getQuestion());
        value.set(model.getValue());
    }
}
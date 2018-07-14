package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableField;

public abstract class TemplateQuestionItemViewModel {

    public final ObservableField<String> question = new ObservableField<>("");

    public TemplateQuestionItemViewModel(String question) {
        this.question.set(question);
    }
}

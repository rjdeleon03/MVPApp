package com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModel;

public abstract class TemplateQuestionItemViewModel {

    public final ObservableField<String> question = new ObservableField<>("");

    public TemplateQuestionItemViewModel(String question) {
        this.question.set(question);
    }
}

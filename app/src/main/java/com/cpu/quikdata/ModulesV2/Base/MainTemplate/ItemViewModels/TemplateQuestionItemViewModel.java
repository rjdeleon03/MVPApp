package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.ObservableField;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;

public abstract class TemplateQuestionItemViewModel<M> {

    public final ObservableField<String> question = new ObservableField<>("");

    public TemplateQuestionItemViewModel(String question) {
        this.question.set(question);
    }

    public abstract M getModel();

    public abstract AppConstants.QuestionItemType getType();
}

package com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.cpu.quikdata.AppConstants;

public abstract class TemplateQuestionItemViewModel<M> extends BaseObservable {

    protected final M mModel;
    public final ObservableField<String> question = new ObservableField<>("");

    public TemplateQuestionItemViewModel(M model) {
        this.mModel = model;
    }

    public abstract M getModel();

    public abstract AppConstants.QuestionItemType getType();

    public abstract void updateModel();
}

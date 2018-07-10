package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.ModulesV2.Base.QuestionModel;

public class TemplateItemViewModel {

    public final ObservableField<String> question = new ObservableField<>("");
    public final ObservableInt male = new ObservableInt(0);
    public final ObservableInt female = new ObservableInt(0);

    public TemplateItemViewModel(QuestionModel model) {
        question.set(model.getQuestion());
        male.set(model.getValue1());
        female.set(model.getValue2());
    }
}

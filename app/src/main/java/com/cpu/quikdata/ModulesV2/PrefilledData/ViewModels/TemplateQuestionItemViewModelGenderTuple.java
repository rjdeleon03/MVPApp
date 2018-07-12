package com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels;

import android.databinding.ObservableInt;

import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelGenderTuple;

public class TemplateQuestionItemViewModelGenderTuple extends TemplateQuestionItemViewModel {

    public final ObservableInt male = new ObservableInt(0);
    public final ObservableInt female = new ObservableInt(0);

    public TemplateQuestionItemViewModelGenderTuple(QuestionItemModelGenderTuple model) {
        super(model.getQuestion());
        male.set(model.getMale());
        female.set(model.getFemale());
    }
}

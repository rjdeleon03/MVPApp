package com.cpu.quikdata.ModulesV2.PrefilledData.ViewModels;

import android.databinding.ObservableInt;

import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelSingleNumber;

public class TemplateQuestionItemViewModelSingleNumber extends TemplateQuestionItemViewModel {

    public final ObservableInt value = new ObservableInt(0);

    public TemplateQuestionItemViewModelSingleNumber(QuestionItemModelSingleNumber model) {
        super(model.getQuestion());
        value.set(model.getValue());
    }
}
